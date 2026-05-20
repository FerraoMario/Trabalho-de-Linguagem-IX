import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;

public class SalarioFinalForm {

    public static void main(String[] args) {

        String nome = JOptionPane.showInputDialog("Nome do funcionário:");
        String genero = JOptionPane.showInputDialog("Gênero (M/F):");
        String contrato = JOptionPane.showInputDialog("Contrato (Efetivo/Contratado):");
        String dataIngresso = JOptionPane.showInputDialog("Data de ingresso (AAAA-MM-DD):");

        double salarioDia = Double.parseDouble(
                JOptionPane.showInputDialog("Salário por dia:"));
        int diasTrabalhados = Integer.parseInt(
                JOptionPane.showInputDialog("Dias trabalhados:"));

        LocalDate ingresso = LocalDate.parse(dataIngresso);
        int anos = Period.between(ingresso, LocalDate.now()).getYears();

        double salarioBase = salarioDia * diasTrabalhados;

        double subsidioFerias = 0;
        double subsidioAntiguidade = 0;
        double impostoIRT = 0.10 * salarioBase;

        if (anos >= 5) {
            if (contrato.equalsIgnoreCase("Efetivo")) {
                subsidioFerias = salarioBase - (salarioBase * 0.20);

                if (genero.equalsIgnoreCase("F")) {
                    subsidioAntiguidade = salarioBase * 0.25;
                } else {
                    subsidioAntiguidade = salarioBase * 0.15;
                }
            } else {
                subsidioAntiguidade = salarioBase * 0.15;
            }
        } else {
            if (contrato.equalsIgnoreCase("Efetivo")) {
                subsidioFerias = salarioBase - (salarioBase * 0.20);

                if (genero.equalsIgnoreCase("F")) {
                    subsidioAntiguidade = salarioBase * 0.20;
                }
            } else {
                subsidioAntiguidade = salarioBase * 0.05;
            }
        }

        double salarioFinal = salarioBase + subsidioFerias + subsidioAntiguidade - impostoIRT;

        String resultado =
                "Nome: " + nome +
                "\nAnos de antiguidade: " + anos +
                "\nSalário base: " + salarioBase +
                "\nSubsídio de férias: " + subsidioFerias +
                "\nSubsídio de antiguidade: " + subsidioAntiguidade +
                "\nImposto IRT: " + impostoIRT +
                "\nSALÁRIO FINAL: " + salarioFinal;

        JOptionPane.showMessageDialog(null, resultado);
    }
}
