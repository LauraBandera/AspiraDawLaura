# AspiraDawLaura
Un aspirador robótico autónomo es aquel que cuenta con una programación inteligente y un sistema de limpieza automatizado. Actualmente son programables y 
no es necesaria la intervención de personas para que realicen su tarea.

La idea del proyecto es poner en práctica todo lo aprendido en el bloque 1 usando como centro de atención la programación de una “supuesta app” para 
controlar el robot aspirador desde un tablet o móvil. Evidentemente nuestra “supuesta app” no estará instalada en ningún dispositivo, si no que se ejecutará 
en nuestro entorno de desarrollo. 

La aplicación solicita y muestra todos los datos al usuario que la está manejando usando JOption.

El sistema de limpieza debe ser capaz de realizar las siguientes tareas, que se presentarán al usuario en forma de menú:

CONFIGURAR EL SISTEMA. 
En esta opción hay que configurar el número de dependencias de la casa y el número de metros cuadrados de cada dependencia. Por 
defecto, y para simplificar, la vivienda tiene una cocina, un salón, un cuarto de baño y dos dormitorios. De cada depedencia, el sistema pregunta el número 
de metros de cada estancia (entre 1 y 100). Esta opción siempre debe ejercutarse la primera vez que se entra en la aplicación. MEJORA OPCIONAL: que se puedan 
configurar viviendas con otro número de dependencias. 

CARGA. 
Establece el nivel de batería. (entre 0% y 100%).

ASPIRACIÓN.
Modo completo. En este modo, la aspiradora limpia el piso entero. El robot va limpiando habitaciones en función de su batería. Si al entrar en una habitación 
no le llega la batería para poder completarla entonces la aspiradora se para e informa al usuario que no puede terminar y también informa de las dependencias 
que ha podido limpiar. 

Modo dependencias. Sólo limpia las habitaciones que se le indiquen, si tiene batería.

En ambos modos, cada metro cuadrado de limpieza agota un 1,5% de batería. Cada vez que se limpia una habitación se actualiza el estado de la batería, para 
controlar si puede limpiar la siguiente habitación.

En ningún caso, si está limpiando la casa o una dependencia, el nivel de batería no puede ser inferior al 3%, para que el robot tenga autonomía y pueda volver 
a su base de carga.

ASPIRACIÓN Y FREGADO. 
Exactamente igual que el anterior pero agota un 2,25% de batería por cada metro cuadrado.

ESTADO GENERAL. 
Esta opción del menú servirá para mostrar:
  La fecha y hora actuales, 
  El nivel de batería del robot,
  Lugar donde está parado,
  Dependencias y metros cuadrados de la casa. 
  
BASE DE CARGA. 
Le indica al robot que busque su base de carga y entre en modo carga de batería, hasta que llegue al 100%.

SALIR. 
Con esta opción termina el programa. La aplicación se ejecutará hasta que el usuario decida cerrarla. 


El menú anterior es accesible cuando el usuario se autentique en la aplicación mediante usuario y contraseña válidos. Estas credenciales se almacenan en la aplicación usando constantes.


RECOMENDACIONES
Como puedes observar, esta aplicación debe resolver múltiples situaciones y llevar el control de muchos casos de uso diferentes. Debes tener en cuenta, para 
poder realizar realizar un buen proyecto, las siguientes recomendaciones: 
  Aplica un diseño descendente, aplicando técnicas “divide y vencerás”. Ve de lo general a lo específico, dejando los detalles para el final.
  Realiza algoritmos para los distintos casos que encuentres.
  Prueba tus algoritmos con distintos casos de prueba.
  Una vez probados, debes integrarlos en la aplicación final. 
  Utiliza control de versiones, de forma que cada pequeño cambio, nuevo método, clase, archivo, etc quede reflejado en Git y GitHub. 
  Ten en cuenta que debes aplicar todo lo aprendido hasta la fecha en el módulo.
  Opcionalmente, y como posibles mejoras, se pueden usar métodos, para modularizar mejor el programa, y arrays, con la finalidad de guardar informarción de una 
  forma más óptima. 
