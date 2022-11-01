# GuessNumberFragment
Esta aplicación cosiste en un juego de adivinar un número en una cantidad de intentos dados 
por el usuario.
Consta de una MainActivity, una AboutUsActivity y tres fragmentos: ConfigFragment, PlayFrgament y EndPLayFragment.

## MainActivity
Activity usada como punto de entrada de la aplicación y que contendrá al resto de fragmentos. Además posee un elemento
menu que nos permite acceder al AboutUsActivity desde cualquier fragmento al estar todos contenidos dentro de la MainActivity.

## AboutUsActivity
Activity cuya única función es crear una view con información acerca del desarrollador y de la aplicación. Sepuede acceder a él
desde cualquier fragmento usando el menú.

<img src = "https://user-images.githubusercontent.com/114061904/199322086-2258dc8d-5f9a-47d5-bab4-a43ed6d8aa37.png" height = "500">

## Game
Objeto POJO usado para guardar los datos del juego.

## ConfigFragment
Fragmento inicial que permite al usuario introducir un nombre de usuario y un número de intentos
en los que intentará adivinar el número.

<img src = "https://user-images.githubusercontent.com/114061904/199324735-7a037076-bda4-4c61-800c-74cdf508c15e.png" height = "500">

Si alguno de los dos campos se encuentra vacío o se introduce caractéres en vez de números como cantidad 
de intentos el botón que inicia el juego se desabilita.

<img src = "https://user-images.githubusercontent.com/114061904/199325085-d836bcba-009a-452e-802b-38b0836aec66.png" height = "500">

<img src = "https://user-images.githubusercontent.com/114061904/199325308-f61abf9a-d3d4-463e-b64c-4147cea5227c.png" height = "500">

## PlayFragment
Es el fragment en la que se desarrolla el juego. El jugador debe introducir un numero en el campo y
comprobar si su respuesta es correcta pulsando el botón, que al igual que en el fragment anterior se
mantiene desactivada y el valor introducido por el jugador es nulo o no es un número.

<img src = "https://user-images.githubusercontent.com/114061904/199325862-592cc880-2c99-4270-ad34-e9512644b902.png" height = "500">

<img src = "https://user-images.githubusercontent.com/114061904/199326028-99a423e9-e24e-4c9f-8201-4163598efade.png" height = "500">

Una vez pulsado el botón, si el jugador no acierta, se muestra un mensaje indicando si el número a acertar
es mayor o menor que el número introducido, desactivando el botón y activando el segundo botón que nos permite
volver a intentarlo en el caso de que nos queden intentos.

<img src = "https://user-images.githubusercontent.com/114061904/199326171-c465e4c4-a349-4baf-b613-42996b476fb2.png" height = "500">

<img src = "https://user-images.githubusercontent.com/114061904/199326317-2b766d34-80e5-43a1-848b-bf6c97eba33d.png" height = "500">

<img src = "https://user-images.githubusercontent.com/114061904/199326683-ca15b949-e938-4527-8671-ce686234dc25.png" height = "500">

## EndPlayFragment
Si el jugador acierta el número antes de que se le agoten los intentos se inicia el tercer fragment
que muestra un mensaje al jugador indicando que este ha ganado y el número de intentos restantes.

<img src = "https://user-images.githubusercontent.com/114061904/199329045-35049426-6a5e-4805-a021-f886426a2ead.png" height = "500">

Si el jugador se queda sin intentos se inicia el tercer que muestra un mensaje indicando
que el jugador ha agotado todos sus intentos.

<img src = "https://user-images.githubusercontent.com/114061904/199329637-f4427f6a-902c-4cf8-99d3-2e6f0ba6569a.png" height = "500">

Una vez se inicia el tercer fragment el juego se da por terminado y se puede volver a jugar pulsando el botón.

## Librerías usadas
https://github.com/jrvansuita/MaterialAbout

## Recursos Usados
<a href="https://www.flaticon.com/free-icons/numbers" title="numbers icons">Numbers icons created by Freepik - Flaticon</a>
