# AnalyzerDna

Examen
Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar
contra los X-Men.
Te ha contratado a ti para que desarrolles un proyecto que detecte si un
humano es mutante basándose en su secuencia de ADN.
Para eso te ha pedido crear un programa con un método o función con la siguiente firma (En
alguno de los siguiente lenguajes: Java / Golang / C-C++ / Javascript (node) / Python / Ruby):

boolean isMutant(String[] dna); // Ejemplo Java

En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla
de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las
cuales representa cada base nitrogenada del ADN.




Para Ejecutar el programa es necesario lo siguiente:

1.- Instalar el JDK 1.8
2.- Instalar maven
3.- Tener el ide desarrollo sts-4.10.0
4.- Descargar o clonar el projecto de github 

    https://github.com/EgarMitchell/AnalyzerDna.git
    
5.- Importar el proyecto en sts , como maven project
6.- Compilar el proyecto con maven install para generar war

     click izq en el proyecto -> run as -> maven install
    
7.- desplegar war en tomcat o directamente desde el sts
8.- Postman para probar o usar la liga de documentacion
    

URL DE API
    https://mutant-analyzer.herokuapp.com

Operacion Post /mutant
    https://mutant-analyzer.herokuapp.com/mutant

Operacion Get /stats
    https://mutant-analyzer.herokuapp.com/stats

URL de la Documentacion (tambien sirve para probar)
    https://mutant-analyzer.herokuapp.com/swagger-ui.html
