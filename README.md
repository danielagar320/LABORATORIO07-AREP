# LABORATORIO 7 AREP

En este laboratorio se desarrollara una aplicación web segura. 

### Autor: Daniela Garcia

### Prerequisitos
* Maven: Herramienta para la gestión y construcción de proyectos.
* Java: Lenguaje de programación.
* Git: Sistema de control de versiones distribuido.
* AWS: Servicio de nube.

## Solución

* Primero se crearon los certificados y sus llaves para poder probar los servidores de manera local.

![](img/img_3.png)

* Para hacer la implementación en AWS se crearon dos instancias, una para cada servidor.

![](img/img_10.png)

* En cada instancia se adicionaron dos reglas de entrada con los puertos que usa cada servidor.

![](img/img.png)

*  En los metodos get se uso el DNS de cada instancia.

![](img/img_1.png)


![](img/img_2.png)

* Se crearon los certificados y las llaves

![](img/img_4.png)

![](img/img_5.png)

![](img/img_6.png)

![](img/img_7.png)
![](img/img_8.png)

![](img/img_9.png)

* En cada servidor se crearon los metodos que se encargaban de obtener el certificado y la llave del otro.

![](img/img_11.png)

![](img/img_12.png)

* Se ejecuto el siguiente comando para generar la carpeta target.

```

mvn clean install

```

![](img/img_13.png)

* Se debe copiar la carpeta que contiene los certificados en la carpeta del target.

![](img/img_22.png)


* Comprimimos la carpeta target en un archivo zip y con los siguientes comandos la pasamos a la instancia y la descomprimimos.

```

put target.zip

unzip target.zip

```



![](img/img15.png)

![](img/img_16.png)

![](img/img_17.png)

* Instalamos java en cada instancia con el siguiente comando: 

```
sudo yum install java-17-amazon-corretto-devel

```

![](img/img_18.png)


* Para correr los servidores ejecutamos en cada maquina el siguiente comando:

```
java -cp "target/classes:target/dependency/*" org.example.ServerOne

java -cp "target/classes:target/dependency/*" org.example.ServerTwo


```


![](img/img_19.png)

![](img/img_20.png)

![](img/img_21.png)


### Autor

* **Daniela García Romero**: [danielagar320](https://github.com/danielagar320)



