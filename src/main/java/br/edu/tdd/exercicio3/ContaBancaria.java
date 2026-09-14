package br.edu.tdd.exercicio3;

import java.util.ArrayList;
import java.util.List;

public class ContaBancaria {

    private double saldo = 0;
    private final List<String> extrato = new ArrayList<>();

    public double getSaldo() {
        return saldo;
    }

    public List<String> getExtrato() {
        return List.copyOf(extrato);
    }

    public void depositar(double valor) {
        validar(valor);
        saldo += valor;
        registrar("DEPOSITO", valor);
    }

    public void sacar(double valor) {
        validar(valor);
        if (valor > saldo) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        saldo -= valor;
        registrar("SAQUE", valor);
    }

    private void validar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor invalido");
        }
    }

    private void registrar(String operacao, double valor) {
        extrato.add(operacao + ": " + valor);
    }
}
