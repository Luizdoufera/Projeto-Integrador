package javamatematica;

import java.util.Scanner;

public class JavaMatematica {

    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

         //i1= chocolate meio amargo | i2= leite condencado | i3= margarina | i4= leite em po | i5= cafe soluvel | i6= coco ralado
         // Receita definida: choc = 400g, leitcond = 395g, marg = 40g, leitpoR1 = 50g, cafeR2 = 100g, cocoR3 = 300g;
         //pi1= preço do chocolate comproda | p2...
         //e1 = estoque de chocolate em grama | e2...
         //preco1 = qtdade em reais de um ingrediente...
         //custoR = custo limite de uma receita. 
         //precoV = de venda.
         //qtdI1 = quantidade comprada em grama de cada ingreediente.
         
         int choc = 0, leitcond = 0, marg = 0, leitpoR1 = 0, cafeR2 = 0, cocoR3 = 0;
         
         System.out.print("Defina a quantidade de - chocolate - equivalente a uma receita: ");
             choc = ler.nextInt();
         System.out.print("Defina a quantidade de - leite condensado - equivalente a uma receita: ");
             leitcond = ler.nextInt();
         System.out.print("Defina a quantidade de - margarina - equivalente a uma receita: ");
             marg = ler.nextInt();
         System.out.print("Defina a quantidade de - leite em pó - equivalente a uma receita: ");
             leitpoR1 = ler.nextInt();
         System.out.print("Defina a quantidade de - café soluvel - equivalente a uma receita: ");
             cafeR2 = ler.nextInt();
         System.out.print("Defina a quantidade de - coco ralado seco - equivalente a uma receita: ");
             cocoR3 = ler.nextInt();
            
         int qtdI1 = 0, qtdI2 = 0, qtdI3 = 0, qtdI4 = 0, qtdI5 = 0, qtdI6 = 0;
         int e1 = 0, e2 = 0, e3 = 0, e4 = 0, e5 = 0, e6 = 0;
         
         float pi1 = 0, pi2 = 0, pi3 = 0, pi4 = 0, pi5 = 0, pi6 = 0;
         float preco1 = 0, preco2 = 0, preco3 = 0, preco4 = 0, preco5 = 0, preco6 = 0;
         float custoR = 0, precoV, lucro = 0, rec1 = 0, rec2 = 0, rec3 = 0;
         
        

         System.out.println("O MELHOR BOMBOM DE GOIANIA");
         System.out.println("----------------------------------------");
         System.out.println("CONTROLE DE PRODUÇÃO E DE SUPRIMETOS");
         System.out.println("----------------------------------------");
         System.out.println("Olá! Abaixo digite o preço dos produtos.");
         System.out.println("----------------------------------------");

         System.out.println("RECEITAS.");
         System.out.println("----------------------------------------");
         System.out.println("BomBom de Leite Ninho");
         System.out.println("BomBom de Cafe");
         System.out.println("BomBom de coco\n");


         System.out.printf("Digite o preço do chocolate comprado. R$ ", pi1);
         pi1 = ler.nextFloat();
         System.out.printf("Digite o preço do leite condensado comprado. R$ ", pi2);
         pi2 = ler.nextFloat();
         System.out.printf("Digite o preço da margarina comprada. R$ ", pi3);
         pi3 = ler.nextFloat();
         System.out.printf("Digite o preço do leite em pó comprado. R$ ", pi4);
         pi4 = ler.nextFloat();
         System.out.printf("Digite o preço do cafe soluvel comprado. R$ ", pi5);
         pi5 = ler.nextFloat();
         System.out.printf("Digite o preço do coco ralado comprado. R$ ", pi6);
         pi6 = ler.nextFloat();

         System.out.println("\nOlá! Abaixo digite o peso dos produtos em grama.");
         System.out.println("--------------------------------------------------");

         System.out.printf("Digite quantos gramas de chocolate comprado. ", qtdI1);
         qtdI1 = ler.nextInt();
         e1 = e1 + qtdI1 - choc;
         System.out.println("Sua quantidade de chocolate restante é " + e1 + "g.");
         e1 = ler.nextInt();
         
         System.out.printf("Digite quantos gramas de leite condensado comprado. ", qtdI2);
         qtdI2 = ler.nextInt();
         e2 = e2 + qtdI2 - leitcond;
         System.out.println("Sua quantidade de leite condensado restante é " + e2 + "g.");
         e2 = ler.nextInt();
         
         System.out.printf("Digite quantos gramas de margarina comprado. ", qtdI3);
         qtdI3 = ler.nextInt();
         e3 = e3 + qtdI3 - marg;
         System.out.println("Sua quantidade de margarina restante é " + e3 + "g.");
         e3 = ler.nextInt();
         
         System.out.printf("Digite quantos gramas de leite em po comprado. ", qtdI4);
         qtdI4 = ler.nextInt();
         e4 = e4 + qtdI4 - leitpoR1;
         System.out.println("Sua quantidade de leite em pó restante é " + e4 + "g.");
         e4 = ler.nextInt();
         
         System.out.printf("Digite quantos gramas de cafe soluvel comprado. ", qtdI5);
         qtdI5 = ler.nextInt();
         e5 = e5 + qtdI5 - cafeR2;
         System.out.println("Sua quantidade de café soluvel restante é " + e5 + "g.");
         e5 = ler.nextInt();
         
         System.out.printf("Digite quantos gramas de coco ralado comprado. ", qtdI6);
         qtdI6 = ler.nextInt();
         e6 = e6 + qtdI6 - cocoR3;
         System.out.println("Sua quantidade de coco ralado restante é " + e6 + "g.");
         e6 = ler.nextInt();
         
         preco1 = pi1 / qtdI1 * e1; // preco do produto ingred comprado x qtde do mesmo em grama Ex: 400 * 5 reais
         preco2 = qtdI2 * pi2;
         preco3 = qtdI3 * pi3;
         preco4 = qtdI4 * pi4;
         preco5 = qtdI5 * pi5;
         preco6 = qtdI6 * pi6;
         
         while (e1 >= choc && e2 >= leitcond && e3 >= marg && e4 >= leitpoR1){
             System.out.println("Temos ingredientes suficientes para 1 receita de BomBom de Leite Ninho. ");
             if(e1 >= choc*2 && e2 >= leitcond*2 && e3 >= marg*2 && e4 >= leitpoR1*2){
                 System.out.println("Temos ingredientes suficientes para 2 receita de BomBom de Leite Ninho. ");
             }if (e1 >= choc*3 && e2 >= leitcond*3 && e3 >= marg*3 && e4 >= leitpoR1*3) {
                 System.out.println("Temos ingredientes suficientes para 3 receita de BomBom de Leite Ninho. ");
            }
         }   
         while (e2 >= choc && e2 >= leitcond && e3 >= marg && e5 >= cafeR2){
             System.out.println("Temos ingredientes suficientes para 1 receita de BomBom de Cafe. ");
             if(e2 >= choc*2 && e2 >= leitcond*2 && e3 >= marg*2 && e5 >= cafeR2*2){
                 System.out.println("Temos ingredientes suficientes para 2 receita de BomBom de Cafe. ");
             }if (e2 >= choc*3 && e2 >= leitcond*3 && e3 >= marg*3 && e5 >= cafeR2*3) {
                 System.out.println("Temos ingredientes suficientes para 3 receita de BomBom de Cafe. ");
            }
         }
         while (e3 >= choc && e2 >= leitcond && e3 >= marg && e6 >= cocoR3){
             System.out.println("Temos ingredientes suficientes para 1 receita de BomBom de coco. ");
             if(e3 >= choc*2 && e2 >= leitcond*2 && e3 >= marg*2 && e6 >= cocoR3*2){
                 System.out.println("Temos ingredientes suficientes para 2 receita de BomBom de coco. ");
             }if (e3 >= choc*3 && e2 >= leitcond*3 && e3 >= marg*3 && e6 >= cocoR3*3) {
                 System.out.println("Temos ingredientes suficientes para 3 receita de BomBom de coco. ");
             }
         }
         
         
         
         System.out.print("Defina o preço de venda por unidade/bombom em uma receita: ");
             precoV = ler.nextInt();
             
             lucro = precoV - custoR;
             
       
    }
}
