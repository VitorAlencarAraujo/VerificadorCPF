import java.util.Scanner;

public class Verificador {
    public static void main(String[] args) {

        /*Desenvolver um aplicativo que leia um CPF e após a sua validação exiba na tela:
        CPF válido! ou
        CPF inválido!*/

        Scanner sc = new Scanner(System.in);

        while (true) {

            int validador1, validador2;

            //Leitura do CPF
            System.out.print("\nInforme o CPF (Apenas números):");
            String cpf = sc.next();

            //Verificar se o CPF tem 11 digitos
            /* cpf.length Retorna o número de caracteres da String CPF */
            if (cpf.length() != 11) {
                System.out.println("CPF Não tem 11 digitos!");
                continue; //Faz voltar para o começo do While
            }


            //Verificar se os numeros do cpf são todos iguais
            boolean TodosIguais = true;

        for (int i = 0; i < cpf.length(); i++){
            if (cpf.charAt(i) != cpf.charAt(0)){
            TodosIguais = false;
            }
        }
            if (TodosIguais) {
                System.out.println("CPF inválido! Todos os dígitos são iguais.");
                continue;
            }

            //Calculo do primeiro digito verificador
            int somaTudo = 0;
        for (int i = 0; i <= 8; i++){

            // *Character.getNumericValue*    Converte Caractere para número
            int numero = Character.getNumericValue(cpf.charAt(i)) * (10 - i);
            somaTudo += numero;

        }
            int restoDoDigito1 = somaTudo%11;

            if (restoDoDigito1 >= 2){
                validador1 = 11 - restoDoDigito1;
            }
            else {
                validador1 = 0;
            }

            int somaTudo2 = 0;
            //Segundo Digito Verificador
            for (int i = 0; i <= 9; i++){
                int numero = Character.getNumericValue(cpf.charAt(i)) * (11 - i);
                somaTudo2 += numero;
            }

            int restoDoDigito2 = somaTudo2%11;

            if (restoDoDigito2 >= 2){
                validador2 = 11 - restoDoDigito2;
            }

            else {
                validador2 = 0;
            }

            //Comparando os digitos com o do CPF informado
            if (validador1 == Character.getNumericValue(cpf.charAt(9)) && validador2 == Character.getNumericValue(cpf.charAt(10))){
                System.out.println("CPF Válido!");

            }
            else {
                System.out.println("CPF Inválido!");
            }
        }
    }
}
