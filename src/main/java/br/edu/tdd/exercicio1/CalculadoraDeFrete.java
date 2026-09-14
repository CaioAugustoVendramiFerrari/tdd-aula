package br.edu.tdd.exercicio1;

public class CalculadoraDeFrete {

    private static final double PESO_MAXIMO_FAIXA_LEVE = 1.0;
    private static final double PESO_MAXIMO_FAIXA_MEDIA = 5.0;
    private static final double FRETE_FAIXA_LEVE = 10.0;
    private static final double FRETE_FAIXA_MEDIA = 18.0;
    private static final double TAXA_POR_KG_EXCEDENTE = 2.50;

    public double calcular(double pesoEmKg) {
        validar(pesoEmKg);

        if (pesoEmKg <= PESO_MAXIMO_FAIXA_LEVE) {
            return FRETE_FAIXA_LEVE;
        }
        if (pesoEmKg <= PESO_MAXIMO_FAIXA_MEDIA) {
            return FRETE_FAIXA_MEDIA;
        }
        return FRETE_FAIXA_MEDIA + excedente(pesoEmKg);
    }

    private double excedente(double pesoEmKg) {
        return (pesoEmKg - PESO_MAXIMO_FAIXA_MEDIA) * TAXA_POR_KG_EXCEDENTE;
    }

    private void validar(double pesoEmKg) {
        if (pesoEmKg <= 0) {
            throw new IllegalArgumentException("Peso invalido");
        }
    }
}
