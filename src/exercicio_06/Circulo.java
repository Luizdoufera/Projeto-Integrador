/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio_06;

/**
 *
 * @author Luiz Fernando
 */
class Circulo implements Forma {
    private double raio;
    private static final double PI = 3.14159;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return PI * raio * raio;
    }

    public void exibirArea() {
        System.out.println("Área do Círculo: " + calcularArea());
    }
}
