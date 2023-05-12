package javamatematica;

import java.util.Scanner;

public class JavaMatematica {

    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        // quantidade de bombons por receita = qtdBom = 50
         //i1= chocolate meio amargo | i2= leite condencado | i3= margarina | i4= leite em po | i5= cafe soluvel | i6= coco ralado
         // Receita definida: choc = 400g, leitcond = 395g, marg = 40g, leitpoR1 = 50g, cafeR2 = 100g, cocoR3 = 300g;
         //pi1= preço do chocolate comproda | pi2...
         //e1 = estoque de chocolate em grama | e2...
         //preco1 = custo do chocolate...
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
         float custoR = 0, precoV, lucroTotal = 0, qtdBom = 50, rec1 = 0, rec2 = 0, rec3 = 0;
         float lucroUnidR1 = 0, lucroUnidR2 = 0, lucroUnidR3 = 0;
        

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
         
         
         System.out.printf("Digite quantos gramas de leite condensado comprado. ", qtdI2);
         qtdI2 = ler.nextInt();
         e2 = e2 + qtdI2 - leitcond;
         System.out.println("Sua quantidade de leite condensado restante é " + e2 + "g.");
         
         
         System.out.printf("Digite quantos gramas de margarina comprado. ", qtdI3);
         qtdI3 = ler.nextInt();
         e3 = e3 + qtdI3 - marg;
         System.out.println("Sua quantidade de margarina restante é " + e3 + "g.");
         
         
         System.out.printf("Digite quantos gramas de leite em po comprado. ", qtdI4);
         qtdI4 = ler.nextInt();
         e4 = e4 + qtdI4 - leitpoR1;
         System.out.println("Sua quantidade de leite em pó restante é " + e4 + "g.");
        
         
         System.out.printf("Digite quantos gramas de cafe soluvel comprado. ", qtdI5);
         qtdI5 = ler.nextInt();
         e5 = e5 + qtdI5 - cafeR2;
         System.out.println("Sua quantidade de café soluvel restante é " + e5 + "g.");
         
         
         System.out.printf("Digite quantos gramas de coco ralado comprado. ", qtdI6);
         qtdI6 = ler.nextInt();
         e6 = e6 + qtdI6 - cocoR3;
         System.out.println("Sua quantidade de coco ralado restante é " + e6 + "g.");
        
         
         preco1 = pi1 / qtdI1 * e1; // preco do produto ingred comprado x qtde do mesmo em grama Ex: 400 * 5 reais
         preco2 = qtdI2 * pi2;
         preco3 = qtdI3 * pi3;
         preco4 = qtdI4 * pi4;
         preco5 = qtdI5 * pi5;
         preco6 = qtdI6 * pi6;
         
         if (e1 >= choc && e2 >= leitcond && e3 >= marg && e4 >= leitpoR1){
             System.out.println("Temos ingredientes suficientes para 1 receita de BomBom de Leite Ninho. ");
             if(e1 >= choc*2 && e2 >= leitcond*2 && e3 >= marg*2 && e4 >= leitpoR1*2){
                 System.out.println("Temos ingredientes suficientes para 2 receita de BomBom de Leite Ninho. ");
             }if (e1 >= choc*3 && e2 >= leitcond*3 && e3 >= marg*3 && e4 >= leitpoR1*3) {
                 System.out.println("Temos ingredientes suficientes para 3 receita de BomBom de Leite Ninho. ");
            }
         }   
         if (e2 >= choc && e2 >= leitcond && e3 >= marg && e5 >= cafeR2){
             System.out.println("Temos ingredientes suficientes para 1 receita de BomBom de Cafe. ");
             if(e2 >= choc*2 && e2 >= leitcond*2 && e3 >= marg*2 && e5 >= cafeR2*2){
                 System.out.println("Temos ingredientes suficientes para 2 receita de BomBom de Cafe. ");
             }if (e2 >= choc*3 && e2 >= leitcond*3 && e3 >= marg*3 && e5 >= cafeR2*3) {
                 System.out.println("Temos ingredientes suficientes para 3 receita de BomBom de Cafe. ");
            }
         }
         if (e3 >= choc && e2 >= leitcond && e3 >= marg && e6 >= cocoR3){
             System.out.println("Temos ingredientes suficientes para 1 receita de BomBom de coco. ");
             if(e3 >= choc*2 && e2 >= leitcond*2 && e3 >= marg*2 && e6 >= cocoR3*2){
                 System.out.println("Temos ingredientes suficientes para 2 receita de BomBom de coco. ");
             }if (e3 >= choc*3 && e2 >= leitcond*3 && e3 >= marg*3 && e6 >= cocoR3*3) {
                 System.out.println("Temos ingredientes suficientes para 3 receita de BomBom de coco. ");
             }
         }
         
         float custoR1 = 0, custoR2 = 0, custoR3 = 0, qtdbombomR = 50;
         float custobombomR1 = 0, custobombomR2 = 0, custobombomR3 = 0;
         float custochoc1 = (pi1/qtdI1) * choc, custoleitcond2 = (pi2/qtdI2) * leitcond, customarg3 = (pi3/qtdI3) * marg, custoleitpo4 = (pi4/qtdI4) * leitpoR1, custocafe5 = (pi5/qtdI5) * cafeR2, custococo6 = (pi6/qtdI6) * cocoR3;
         
         System.out.print("Defina/digite o preço de venda por unidade/bombom em uma receita: ");
             precoV = ler.nextInt();
             
             custoR1 = custochoc1 + custoleitcond2 + customarg3 + custoleitpo4; 
             custoR2 = custochoc1 + custoleitcond2 + customarg3 + custocafe5;    
             custoR3 = custochoc1 + custoleitcond2 + customarg3 + custococo6;
             
             custobombomR1 = (custoR1/qtdbombomR); //custo da receita 1 dividido pela quantidade de bombom que são 50 por receita.
             custobombomR2 = (custoR2/qtdbombomR);
             custobombomR3 = (custoR3/qtdbombomR);
             
             int qtvendidaR1 = 0, qtvendidaR2 = 0, qtvendidaR3 = 0;
             int registroVendaR1, registroVendaR2, registroVendaR3;
             
             System.out.print("Bombons de chocolates vendidos: ");
             qtvendidaR1 = ler.nextInt();
             registroVendaR1 = qtvendidaR1;
             
             System.out.print("Bombons de cafe vendidos: ");
             qtvendidaR2 = ler.nextInt();
             registroVendaR2 = qtvendidaR2;
             
             System.out.print("Bombons de coco vendidos: ");
             qtvendidaR3 = ler.nextInt();
             registroVendaR3 = qtvendidaR3;
             
             lucroUnidR1 = precoV - custobombomR1 * qtvendidaR1;
             lucroUnidR2 = precoV - custobombomR2 * qtvendidaR2;
             lucroUnidR3 = precoV - custobombomR3 * qtvendidaR3;
             
             
             lucroTotal = lucroUnidR1 + lucroUnidR2 + lucroUnidR3;
       
       
    }
}
