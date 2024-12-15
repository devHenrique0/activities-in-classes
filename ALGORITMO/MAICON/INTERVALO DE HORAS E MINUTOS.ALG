algoritmo "Intervalo de Horas e Minutos"
var
   horaInicio, minutoInicio, horaFim, minutoFim, hora, minuto: inteiro
inicio
   escreva("Digite a hora inicial: ")
   leia(horaInicio)
   escreva("Digite os minutos iniciais: ")
   leia(minutoInicio)

   escreva("Digite a hora final: ")
   leia(horaFim)
   escreva("Digite os minutos finais: ")
   leia(minutoFim)

   escreva("Horas e minutos no intervalo:")

   hora <- horaInicio
   minuto <- minutoInicio

   enquanto (hora < horaFim) ou ((hora = horaFim) e (minuto <= minutoFim)) faca
      escreva(hora, ":")
      se minuto < 10 entao
         escreva("0")
      fimse
      escreva(minuto)

      minuto <- minuto + 1

      se minuto = 60 entao
         minuto <- 0
         hora <- hora + 1
      fimse

      escreval()
   fimenquanto
fimalgoritmo
