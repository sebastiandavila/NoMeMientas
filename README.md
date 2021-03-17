# NoMeMientas
# casos de uso por realizar

## lookForWinnerInGame
Al finalizar una ronda se debe verificar que al menos dos jugadores aun tengan un capital para seguir en el juego, ya que de no cunplirse, y que solo un jugador posea capital este seria el ganador del juego y se daria por terminado.
Esto se realiza recorriendo los jugadores que estan en el juego y verificando la cantidad de estos que posean un capital, este dato va a ser usado para la creacion de la siguiente ronda en caso de ser necesario, ya que si existe un ganador no se necesita una nueva ronda



## searchActivePlayersNextPhase
Cada que una etapa termine se debe verificar quienes siguen activos para dar paso a la siguiente etapa, este caso de uso debe generar un evento que almacene los ids de los jugadores que aun esten activos y que no hayan sido apartados en etapas anteriores y que cumplan con las condiciones para continuar en la ronda actual.
Se tienen que verificar las apuestas realizadas por cada jugador en la etapa anterior, esta apuesta se compara con los dados de la ronda en curso, luego de analizar las posibilidades se decide si es posible que cada jugador tenga opciones de ganar, si es imposible que pueda ganar entonces este jugador sera apartado en la etapa.

