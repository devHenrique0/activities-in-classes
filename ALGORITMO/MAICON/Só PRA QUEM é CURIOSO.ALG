Algoritmo "s� pra quem � curioso"
// Disciplina   : [Linguagem e L�gica de Programa��o]
// Professor   : Antonio Carlos Nicolodi 
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 03/10/2023
Var
// Se��o de Declara��es das vari�veis 
estadoCivil: caractere
casado,solteiro,viuvo,outros,contador,total: inteiro

Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc... 
  Escreval("#######LEGENDA########")
  Escreval("Solteiro(a) - S")
  Escreval("Casado(a) - C")
  Escreval("Viuvo(a) - V")
  Escreval("Outro(a) - INDISPONIVEL")
  ESCREVAL("")
  casado<-0
  solteiro<-0
  viuvo<-0
  outros <- 0
  
  PARA contador de 1 ate 6 faca
   ESCREVA("Pessoa ",contador," Estado Civil(s/c/v):")
   Leia(estadoCivil)
    Se (estadoCivil = "s") ou (estadoCivil = "S") entao
       solteiro <- solteiro + 1
       senao
            Se (estadoCivil = "c") ou (estadoCivil = "C") entao
            casado <- casado + 1
                 senao
                      Se (estadoCivil = "v") ou (estadoCivil = "V") entao
                      viuvo <- viuvo + 1
                            senao
                            outros <- outros + 1
                      fimse
            fimse
    fimse
    
    Fimpara
    
    total <- solteiro+casado+viuvo+outros
    
    Escreval("##### ESQUECI O QUE COLOCA AQUI #####")
    Escreval("Solteiro: ",solteiro )
    Escreval("Casado: ",casado )
    Escreval("Viuvo: ",viuvo )
    Escreval("Outros: ", outros)
    Escreval("-------------------------------------")
    Escreval("total: ", total)

Fimalgoritmo