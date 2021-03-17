# NoMeMientas
# casos de uso por realizar

## lookForWinnerInGame
Al finalizar una ronda se debe verificar que al menos dos jugadores aun tengan un capital para seguir en el juego, ya que de no cunplirse, y que solo un jugador posea capital este seria el ganador del juego y se daria por terminado.
Esto se realiza recorriendo los jugadores que estan en el juego y verificando la cantidad de estos que posean un capital, este dato va a ser usado para la creacion de la siguiente ronda en caso de ser necesario, ya que si existe un ganador no se necesita una nueva ronda

## assignBets
En este caso de uso debe verificarse que la apuesta sea valida antes de ser relacionada a un jugador, se debe evaluar que el jugador cuenta con el capital necesario que se plantea al momento de realizar la apuesta, tambien que su adivinanza sea valida y este caso de uso debe guardar el dinero acumulado de las apuestas y ademas las adivinanzas de los jugadores para que puedan ser usadas en la etapa para verificar si existen ganadores o  si alguno debe salir dependiendo de la etapa en la que se encuentren

## startPhase1
Se dara inicio a la etapa numero uno de una ronda cualquiera, en esta etapa luego de recibir las apuestas de los jugadores se destaparan tres dados o en otras palabras seran visibles para los jugadores, luego de realizar esto se verificaran las adivinanzas de los jugadores, para encontrar los jugadores aptos para seguir ya existe otro caso de uso

## searchActivePlayersNextPhase
Cada que una etapa termine se debe verificar quienes siguen activos para dar paso a la siguiente etapa, este caso de uso debe generar un evento que almacene los ids de los jugadores que aun esten activos y que no hayan sido apartados en etapas anteriores y que cumplan con las condiciones para continuar en la ronda actual.
Se tienen que verificar las apuestas realizadas por cada jugador en la etapa anterior, esta apuesta se compara con los dados de la ronda en curso, luego de analizar las posibilidades se decide si es posible que cada jugador tenga opciones de ganar, si es imposible que pueda ganar entonces este jugador sera apartado en la etapa.

