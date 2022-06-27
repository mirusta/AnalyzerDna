package com.mutant.dna.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mutant.dna.entity.TabDna;
import com.mutant.dna.exceptions.AlreadyExistsException;
import com.mutant.dna.exceptions.BadRequestException;
import com.mutant.dna.exceptions.ErrorException;
import com.mutant.dna.repository.DnaRepository;
import com.mutant.dna.service.DnaService;

/**
 * @author EDGAR CONTRERAS
 *
 */
@Service
public class DnaServiceImpl implements DnaService {

	private final Logger log = LogManager.getLogger(this.getClass());

	@Autowired
	private Environment env;

	@Autowired
	private DnaRepository repository;

	@Override
	@Transactional
	public boolean isMutant(String[] dna) {

		long start = System.currentTimeMillis();

		log.info("Validando duplicado");
		try {
			Optional<TabDna> op = repository.findById(Arrays.toString(dna));			
			if (op.isPresent()) {
				throw new AlreadyExistsException("Cadena analizada, isMutant : " + op.get().isDnaIsMutant());
			}
			
		} catch (Exception e) {
			log.info(e.getLocalizedMessage());
			throw new ErrorException("Error al consultar");
		}	

		String REGEX = env.getProperty("adn.secuencia.regex");
		Integer NXN = Integer.valueOf(env.getProperty("adn.secuencia.nxn"));

		List<String> cadenas = new ArrayList<String>();

		/*
		 * validando que los string cumplan con los carateres validos agregando las
		 * cadenas una lista
		 * 
		 * @exception: genera una excepcion cuando un string no cumple con los
		 * caracteres
		 * 
		 */
		for (String str : dna) {
			if (str.matches(REGEX)) {
				cadenas.add(str.trim());
			} else {
				throw new BadRequestException("Caracter No valido en secuencia");
			}
		}

		/*
		 * validando que la lista contenga el tamaño correcto
		 * 
		 * @exception: genera una excepcion sino cumple con el tamaño correcto
		 * 
		 */
		if (cadenas.size() != NXN) {
			throw new BadRequestException("Cantidad de cadenas de adn , no validas ");
		}

		/*
		 * validando que los string cumplan con la longuitud correcta
		 * 
		 */
		cadenas = cadenas.stream().filter(c -> c.length() == NXN).collect(Collectors.toList());

		/*
		 * validando que la lista contenga el tamaño correcto despues de el filtrado
		 * 
		 * @exception: genera una excepcion sino cumple con el tamaño correcto *
		 */
		if (cadenas.size() != NXN) {
			throw new BadRequestException("longitud de cadenas de adn , no validas ");
		}

		Integer COINCIDENCIA = Integer.valueOf(env.getProperty("adn.secuencia.coincidencias"));

		/*
		 * calculando si cabe la posibilidad de que se encentren dos o mas coincidecias
		 * en un string
		 * 
		 */
		double secuencias_internas = (double) NXN / COINCIDENCIA;

		List<String> muestras = new ArrayList<>();

		/*
		 * 
		 * agregando lineas horizontales
		 * 
		 */
		log.info(" agregando lineas horizontales");
		muestras.addAll(generaSubCadenas(cadenas, COINCIDENCIA, secuencias_internas));
		/*
		 * agregando lineas oblicuas
		 * 
		 */
		log.info(" agregando lineas oblicuas");
		muestras.addAll(generaSubCadenas(generaOblicuas(cadenas, COINCIDENCIA), COINCIDENCIA, secuencias_internas));
		/*
		 * agregando lineas verticales
		 * 
		 */
		log.info(" agregando lineas verticales");
		muestras.addAll(generaSubCadenas(verticales(cadenas, COINCIDENCIA), COINCIDENCIA, secuencias_internas));

		
		List<String> secuencia_admitida = Arrays
				.asList(StringUtils.commaDelimitedListToStringArray(env.getProperty("adn.secuencia.admitidas")));

		muestras = muestras.stream().filter(m -> secuencia_admitida.stream().anyMatch(sa -> m.contains(sa)))
				.collect(Collectors.toList());

		Integer COINCIDENCIA_MIN = Integer.valueOf(env.getProperty("adn.secuencia.min"));

		log.info("Muestras encontradas : {}", muestras.size());
		try {
			repository.save(new TabDna(Arrays.toString(dna), muestras.size() >= COINCIDENCIA_MIN));
		} catch (Exception e) {
			log.info(e.getLocalizedMessage());
			throw new ErrorException("Error al guardar");
		}

		long end = System.currentTimeMillis();
		double time = (double) (end - start);

		log.info("proceso {}  mil-segundos", time);

		return muestras.size() >= COINCIDENCIA_MIN;
	}

	private List<String> generaOblicuas(List<String> cadenas, Integer nChar) {

		List<String> resultado = new ArrayList<>();
		int inicio = cadenas.size() - nChar;
		int contador = inicio;

		while (contador >= 0) {
			resultado.add(generaDiagonalDD_O(contador, cadenas));
			contador--;
		}

		contador = 1;
		char[] cadena = cadenas.get(0).toCharArray();
		while (contador <= inicio) {
			resultado.add(generaDiagonalDD_C(cadena[contador], cadenas, ++contador));

		}

		inicio = (cadenas.size() - nChar) + 1;
		contador = inicio;

		while (contador < cadenas.size()) {
			resultado.add(generaDiagonalDI_O(contador, cadenas));
			contador++;
		}

		contador = 1;
		cadena = cadenas.get(cadenas.size() - 1).toCharArray();
		while (contador < inicio) {
			resultado.add(generaDiagonalDI_C(cadena[contador], cadenas, ++contador));

		}

		return resultado;
	}

	private List<String> verticales(List<String> cadenas, Integer cOINCIDENCIA) {
		List<String> resultado = new ArrayList<>();
		StringBuffer bf = null;
		int inicio = 0;
		while (inicio < cadenas.size()) {
			bf = new StringBuffer();
			for (int i = 0; i < cadenas.size(); i++) {
				bf.append(cadenas.get(i).charAt(inicio));
			}
			inicio++;
			resultado.add(bf.toString());
		}
		return resultado;
	}

	private List<String> generaSubCadenas(List<String> cadenas, int sec, double construir) {

		if (construir >= 2) {
			List<String> resultado = new ArrayList<>();
			int y = 0;
			for (String str : cadenas) {
				y = sec;
				for (int i = 0; y <= str.length(); i++) {
					resultado.add(str.substring(i, y));
					y++;
				}
			}
			return resultado;
		}
		return cadenas;
	}

	private String generaDiagonalDI_O(int inicio, List<String> cadenas) {

		StringBuffer bf = new StringBuffer();
		int siguiente = inicio;
		char[] cadena = cadenas.get(inicio).toCharArray();
		for (int i = 0; siguiente > 0; i++) {
			if (i > 0) {
				siguiente--;
				cadena = cadenas.get(siguiente).toCharArray();
			}
			bf.append(cadena[i]);
		}
		return bf.toString();
	}

	private String generaDiagonalDI_C(char c, List<String> cadenas, int x) {

		StringBuffer bf = new StringBuffer();
		bf.append(c);
		int lista = cadenas.size() - 2;

		char[] cadena = null;

		while (x < cadenas.size()) {
			cadena = cadenas.get(lista).toCharArray();
			lista--;
			bf.append(cadena[x]);
			x++;
		}
		return bf.toString();

	}

	private String generaDiagonalDD_O(int inicio, List<String> cadenas) {
		StringBuffer bf = new StringBuffer();
		int siguiente = inicio;
		char[] cadena = cadenas.get(inicio).toCharArray();
		for (int i = 0; siguiente < cadenas.size() - 1; i++) {
			if (i > 0) {
				siguiente++;
				cadena = cadenas.get(siguiente).toCharArray();
			}
			bf.append(cadena[i]);
		}
		return bf.toString();
	}

	private String generaDiagonalDD_C(char c, List<String> cadenas, int x) {
		StringBuffer bf = new StringBuffer();
		bf.append(c);
		int lista = 1;

		char[] cadena = null;

		while (x < cadenas.size()) {
			cadena = cadenas.get(lista).toCharArray();
			lista++;
			bf.append(cadena[x]);
			x++;
		}
		return bf.toString();
	}

}