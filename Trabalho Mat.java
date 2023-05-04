public static void main(String[] args, int Chocolate) {
        Scanner ler = new Scanner(System.in);
        
        //i1= chocolate meio amargo | i2= leite condencado | i3= margarina | i4= leite em po | i5= cafe soluvel | i6= coco ralado
        //p1= qtde de chocolate comproda | p2...
        //e1 = estoque de chocolate em grama | e2...
        
        double i1R = 400, i2R = 395, i3R = 40, i4R = 50, i5R = 100, i6R = 300;
        double i1 = 0, i2 = 0, i3 = 0, i4 = 0, i5 = 0, i6 = 0;
        double p1 = 400, p2 = 395, p3 = 40, p4 = 50, p5 = 100, p6 = 300;
        double e1 = 0, e2 = 0, e3 = 0, e4 = 0, e5 = 0, e6 = 0;
        float = 
        int r1;
        int r2;
        int r3;
        
        
        
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
        System.out.println("BomBom de coco");
        
        
        System.out.printf("Digite o preço do chocolate. R$ ", i1);
        i1 = ler.nextDouble();
        System.out.printf("Digite o preço do leite condensado. R$ ", i2);
        i2 = ler.nextDouble();
        System.out.printf("Digite o preço da margarina. R$ ", i3);
        i3 = ler.nextDouble();
        System.out.printf("Digite o preço do leite em pó. R$ ", i4);
        i4 = ler.nextDouble();
        System.out.printf("Digite o preço do cafe soluvel. R$ ", i5);
        i5 = ler.nextDouble();
        System.out.printf("Digite o preço do coco ralado. R$ ", i6);
        i6 = ler.nextDouble();
       
        System.out.println("Olá! Abaixo digite o peso dos produtos em grama.");
        System.out.println("--------------------------------------------------");
        
        System.out.printf("Digite quantos gramas de chocolate. ", p1);
        p1 = ler.nextDouble();
        System.out.printf("Digite quantos gramas de leite condensado. ", p2);
        p2 = ler.nextDouble();
        System.out.printf("Digite quantos gramas de margarina. ", p3);
        p3 = ler.nextDouble();
        System.out.printf("Digite quantos gramas de leite em po. ", p4);
        p4 = ler.nextDouble();
        System.out.printf("Digite quantos gramas de cafe soluvel. ", p5);
        p5 = ler.nextDouble();
        System.out.printf("Digite quantos gramas de coco ralado. ", p6);
        p6 = ler.nextDouble();
       
        
        System.out.println("ESTOQUE. Quantidade restante de cada ingrediente.");
        System.out.println("--------------------------------------------------");
        
        System.out.printf("Sua quantidade de chocolate restante é ", e1 + p1);
        e1 = ler.nextDouble();
        System.out.printf("Sua quantidade de leite condensado restante é ", e2 + p2);
        e2 = ler.nextDouble();
        System.out.printf("Sua quantidade de margarina restante é ", e3 + p3);
        e3 = ler.nextDouble();
        System.out.printf("Sua quantidade de leite em pó restante é ", e4 + p4);
        e4 = ler.nextDouble();
        System.out.printf("Sua quantidade de café soluvel restante é ", e5 + p5);
        e5 = ler.nextDouble();
        System.out.printf("Sua quantidade de coco ralado restante é ", e6 + p6);
        e6 = ler.nextDouble();
        
        
        
        
    }
    
}
