package javamatematica;

import java.util.Scanner;

public class JavaMatematica {

    
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
         
         int choc, leitcond, marg, leitpoR1, cafeR2, cocoR3;
         
        
            
         int qtdI1 = 0, qtdI2 = 0, qtdI3 = 0, qtdI4 = 0, qtdI5 = 0, qtdI6 = 0;
         int e1 = 0, e2 = 0, e3 = 0, e4 = 0, e5 = 0, e6 = 0;
         int opcao = 0;
         int freceitas = 0;
         
         float pi1 = 0, pi2 = 0, pi3 = 0, pi4 = 0, pi5 = 0, pi6 = 0;
         float preco1 = 0, preco2 = 0, preco3 = 0, preco4 = 0, preco5 = 0, preco6 = 0;
         float precoV = 0, lucroTotal;
         float lucroUnidR1, lucroUnidR2, lucroUnidR3;
          

         System.out.println("O MELHOR BOMBOM DE GOIÂNIA");
         System.out.println("----------------------------------------");
         System.out.println("GESTÃO DE COMPRAS, SUPRIMENTOS, PRODUÇÃO E VENDAS. ");
         System.out.println("----------------------------------------");
         System.out.println("RECEITAS DE BOMBOM.");
         System.out.println("----------------------------------------");
         System.out.println("BomBom de Leite Ninho");
         System.out.println("BomBom de Cafe");
         System.out.println("BomBom de coco\n");
         System.out.print("------------------------------------------\n");
         
         System.out.println("SUPRIMENTOS. \n");
         

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
         System.out.print("----------------------------------------------------------------------\n");    
            
         System.out.println("COMPRAS. ");
        
         System.out.println("Olá! Abaixo digite o preço dos produtos.\n");
         
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
         System.out.println("---------------------------------------------------\n");
         

         System.out.println("\nOlá! Abaixo digite o peso dos produtos em grama.");
         System.out.println("--------------------------------------------------\n");
         
        
         System.out.print("Digite quantos gramas de chocolate comprado: ");
         qtdI1 = ler.nextInt();
         
         System.out.print("Digite quantos gramas de leite condensado comprado: ");
         qtdI2 = ler.nextInt();
         
         System.out.print("Digite quantos gramas de margarina comprado: ");
         qtdI3 = ler.nextInt();
         
         System.out.print("Digite quantos gramas de leite em po comprado: ");
         qtdI4 = ler.nextInt();
         
         System.out.print("Digite quantos gramas de cafe soluvel comprado: ");
         qtdI5 = ler.nextInt();
         
         System.out.print("Digite quantos gramas de coco ralado comprado: ");
         qtdI6 = ler.nextInt();
        
         System.out.print("---------------------------------------------------\n");
         
         
         //preco1 = pi1 / qtdI1 * e1; // preco do produto ingred comprado x qtde do mesmo em grama Ex: 400 * 5 reais
         //preco2 = qtdI2 * pi2;
         //preco3 = qtdI3 * pi3;
         //preco4 = qtdI4 * pi4;
         //preco5 = qtdI5 * pi5;
         //preco6 = qtdI6 * pi6;
         
        // À seguir a implementação para conferir se a ou não possibilidade de fazer alguma receita   
        int quantre1;
        quantre1 = Math.min(qtdI1 / choc,
                Math.min(qtdI2 / leitcond,
                        Math.min(qtdI3 / marg,
                                qtdI4 / leitpoR1)));
        if (quantre1 >= 1){ 
        System.out.println("Podem ser feitas " + quantre1 + " receitas de BomBom(s) de leite ninho\n ou");}
        if (quantre1 < 1){ 
        System.out.println("Não é possivel fazer nenhuma receita de BomBom de leite ninho");}
        
         int quantre2 = Math.min(qtdI1 / choc,
                Math.min(qtdI2 / leitcond,
                        Math.min(qtdI3 / marg,                              
                                qtdI5 / cafeR2)));
         if (quantre2 >= 1){
         System.out.println("Podem ser feitas " + quantre2 + " receitas de BomBom(s) de café soluvel\n ou");}
         if (quantre1 < 1){ 
        System.out.println("Não é possivel fazer nenhuma receita de BomBom de café soluvel");}
         
         int quantre3 = Math.min(qtdI1 / choc,
                Math.min(qtdI2 / leitcond,
                        Math.min(qtdI3 / marg,                              
                                qtdI6 / cocoR3)));
         if (quantre3 >= 1){
         System.out.println("Podem ser feitas " + quantre3 + " receitas de BomBom(s) de coco");}
         if (quantre1 < 1){ 
        System.out.println("Não é possivel fazer nenhuma receita de BomBom de coco");}
         
         if (quantre1 < 1 && quantre2 < 1 && quantre3 < 1){ 
        System.out.println("Não é possivel fazer nenhuma receita");
        System.exit(0);}
        
        System.out.println("---------------------------------------------------");
        System.out.print("Quantidade de receitas que desejão ser feitas: ");
        freceitas = ler.nextInt();
        System.out.println("---------------------------------------------------");
         
        while (opcao != 1 && opcao != 2 && opcao != 3 ) {
            System.out.println("\nSelecione a receita que você deseja proserguir :");
            System.out.println("1 - leite ninho");
            System.out.println("2 - café soluvel");
            System.out.println("3 - BomBom de coco");
            System.out.print("Opção: ");
            
            opcao = ler.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.println("Você selecionou a opção 1.");
                    e1 = qtdI1 - choc * freceitas;
                    e2 = qtdI2 - leitcond * freceitas;
                    e3 = qtdI3 - marg * freceitas;
                    e4 = qtdI4 - leitpoR1 * freceitas;
                    e5 = qtdI5;
                    e6 = qtdI6;
                    break;
                case 2:
                    System.out.println("Você selecionou a opção 2.");
                    e1 = qtdI1 - choc * freceitas;
                    e2 = qtdI2 - leitcond * freceitas;
                    e3 = qtdI3 - marg * freceitas;
                    e4 = qtdI4;
                    e5 = qtdI5 - cafeR2 * freceitas;
                    e6 = qtdI6;
                    break;
                case 3:
                    System.out.println("Você selecionou a opção 3.");
                    e1 = qtdI1 - choc * freceitas;
                    e2 = qtdI2 - leitcond * freceitas;
                    e3 = qtdI3 - marg * freceitas;
                    e4 = qtdI4;
                    e5 = qtdI5;
                    e6 = qtdI6 - cocoR3 * freceitas;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;             
                
            }
            System.out.println();
        }

        
        
        //System.out.print("Qualtas receitas você deseja fazer ? ");
        //freceitas = ler.nextInt();
        
        System.out.print("\nEstoque remanecente: \n");
        System.out.print("------------------------------------------------------------\n");
        
         System.out.println("Sua quantidade de chocolate restante é " + e1 + "g.");
         
         System.out.println("Sua quantidade de leite condensado restante é " + e2 + "g.");
         
         System.out.println("Sua quantidade de margarina restante é " + e3 + "g.");
         
         System.out.println("Sua quantidade de leite em pó restante é " + e4 + "g.");
         
         System.out.println("Sua quantidade de café soluvel restante é " + e5 + "g.");
         
         System.out.println("Sua quantidade de coco ralado restante é " + e6 + "g.");
         
         
        System.out.print("------------------------------------------------------------\n");
         System.out.println("FINANCEIRO/VENDAS\n ");
        //custoR1 = a custo unitatio de cada BomBom...
        //custochoc1 = custo de cada ingrediente ...
         float custoR1, custoR2, custoR3, qtdbombomR = 50;
         float custobombomR1, custobombomR2, custobombomR3;
         float custochoc1 = (pi1/qtdI1) * choc, custoleitcond2 = (pi2/qtdI2) * leitcond, customarg3 = (pi3/qtdI3) * marg, custoleitpo4 = (pi4/qtdI4) * leitpoR1, custocafe5 = (pi5/qtdI5) * cafeR2, custococo6 = (pi6/qtdI6) * cocoR3;
         
        System.out.printf("Defina/digite o preço de venda por unidade/bombom em uma receita R$ : ");
        precoV = ler.nextFloat();
             
        //custo total de todos os ingrediente      
        custoR1 = custochoc1 + custoleitcond2 + customarg3 + custoleitpo4; 
        custoR2 = custochoc1 + custoleitcond2 + customarg3 + custocafe5;    
        custoR3 = custochoc1 + custoleitcond2 + customarg3 + custococo6;
             
        custobombomR1 = (custoR1/qtdbombomR); //custo da receita 1 dividido pela quantidade de bombom que são 50 por receita.
        System.out.printf("O custo unitário do bombom de chocolate é R$ %.2f" , custobombomR1);
        custobombomR2 = (custoR2/qtdbombomR);
        System.out.printf("\nO custo unitário do bombom de café é R$ %.2f" , custobombomR2);
        custobombomR3 = (custoR3/qtdbombomR);
        System.out.printf("\nO custo unitário do bombom de coco é R$ %.2f" , custobombomR3);
             
        float qtvendidaR1, qtvendidaR2, qtvendidaR3;
             //float registroVendaR1 = 0, registroVendaR2 = 0, registroVendaR3 = 0;
             
        System.out.print("\nBombons de chocolates vendidos: "); // quantidade vendida digitado pelo usuario
        qtvendidaR1 = ler.nextInt();
             
             
        System.out.print("Bombons de cafe vendidos: ");
        qtvendidaR2 = ler.nextInt();
             
             
        System.out.print("Bombons de coco vendidos: ");
        qtvendidaR3 = ler.nextInt();
        
        System.out.print("---------------------------------------------------\n");     
        // lucro de unidade vendida      
        lucroUnidR1 = precoV - custobombomR1;
        System.out.printf("Lucro unitário das vendas de Bombons de Chocolate: R$ %.2f\n" , lucroUnidR1);
        lucroUnidR2 = precoV - custobombomR2;
        System.out.printf("Lucro unitário das vendas de Bombons de Café: R$ %.2f\n" , lucroUnidR2);
        lucroUnidR3 = precoV - custobombomR3;
        System.out.printf("Lucro unitário das vendas de Bombons de Coco: R$ %.2f \n" , lucroUnidR3);
             
        System.out.print("---------------------------------------------------\n"); 
        
        float lucroTotalR1, lucroTotalR2, lucroTotalR3;
        // lucro de cada receita pela quantidade de BomBons vendidos 
        lucroTotalR1 = (lucroUnidR1 * qtvendidaR1);
        System.out.printf("O lucro TOTAL de vendas de Bombons de Chocolate é: R$ %.2f\n" , lucroTotalR1);
        lucroTotalR2 = (lucroUnidR2 * qtvendidaR2);
        System.out.printf("O lucro TOTAL de vendas de Bombons de Café é: R$ %.2f\n" , lucroTotalR2);
        lucroTotalR3 = (lucroUnidR3 * qtvendidaR3);
        System.out.printf("O lucro TOTAL de vendas de Bombons de Coco é: R$ %.2f\n", lucroTotalR3);
        
        System.out.println("----------------------------------------------------\n");
        //somatoria de todos os lucros 
        lucroTotal = lucroTotalR1 + lucroTotalR2 + lucroTotalR3;
        System.out.printf("O lucro TOTAL de vendas é: R$ %.2f " , lucroTotal);
       
    }
}
