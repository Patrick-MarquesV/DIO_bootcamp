package DIO_bootcamp.OO;

public class estudo {
    public static void main(String[] args) {
        
        Carro carro1 = new Carro();
        carro1.setCor("vermelho");
        carro1.setModelo("mobi");
        carro1.setCapacidadeTanque(10);

        System.out.println("Carro: ");
        System.out.println("Modelo: " + carro1.getModelo());

        System.out.print("Valor total para encher o tanque do Carro1: ");
        System.out.println(carro1.totalValorTanque(5.50));
        
        Carro carro2 = new Carro("azul", "onix", 46);

        System.out.println("Carro: ");
        System.out.println("Modelo: " + carro2.getModelo());

        System.out.print("Valor total para encher o tanque do Carro2: ");
        System.out.println(carro2.totalValorTanque(5.50));

        //Upcast -- subir de classe, Faxeineiro sobe para a classe mais generica funcionario

        Funcionario funcionario1 = new Faxineiro();
        Funcionario funcionario2 = new Vendedor();

        //Downcast -- descer de classe, funcionario desce para a classe mais especifica gerente

        // Gerente gerente1 = (Gerente) new Funcionario();

        // Vendedor vendedor1 = (Vendedor) new Funcionario();


        //POLIMORFISMO E SOBRESCRITA

        //vetor de objetos
        ClasseMae[] classes = new ClasseMae[]{new ClasseFilha1(), new ClasseFilha2(), new ClasseMae()};

        //aqui ocorre polimorfismo do metodo1 nas classes filhas 1 e 2 pois ambas possuem o mesmo metodo com funçoes diferentes da classe mae
        for (ClasseMae classe : classes) {
            classe.metodo1();
        }

        System.out.println();

        //aqui ocorre polimorfismo tambem na classe filha 2 no metodo 2.
        for (ClasseMae classe : classes) {
            classe.metodo2();
        }
        
        System.out.println();

        //Aqui ocorre sobrescrita, pois estamos trabalhando diretamento com a subclasse Classe filha 2
        ClasseFilha2 classeFilha2 = new ClasseFilha2();
        classeFilha2.metodo2();



    }
}

class Veiculo{ //Superclasse ou pai
    String cor; //Atributos
    String modelo;
    int capacidadeTanque;

    //Sobrecarga do construtor sem utilizar parametros 
    //Na sobrecarga alteramos os argumentos para dar funções diferentes aos metodos de acordo com a quantidade ou tipo de parametros passados na chamada
    Veiculo(){

    }

    //Construtor com parametros
    Veiculo(String cor, String modelo, int capacidadeTanque){
        this.cor = cor;
        this.modelo = modelo;
        this.capacidadeTanque = capacidadeTanque;
    }

    //Set para settar uma caracteristica
    void setCor(String cor){
        this.cor = cor;
    }

    //Get para exibir essa caracteristica
    String getCor(){
        return cor;
    }

    void setModelo(String modelo){
        this.modelo = modelo;
    }

    String getModelo(){
        return modelo;
    }

    void setCapacidadeTanque(int capacidadeTanque){
        this.capacidadeTanque = capacidadeTanque;
    }

    int getCapacidadeTanque(){
        return capacidadeTanque;
    }

    //Metodo de calculo do valor para encher o tanque do carro
    double totalValorTanque(double valorCombustivel){
        return capacidadeTanque*valorCombustivel;
    }

}

class Carro extends Veiculo { //Subclasse ou filha de veiculo
    
    int portas;

    Carro(){
        
    }

    //Construtor com parametros
    Carro(String cor, String modelo, int capacidadeTanque){
        this.cor = cor;
        this.modelo = modelo;
        this.capacidadeTanque = capacidadeTanque;
    }
    

}

class Moto extends Veiculo{//Subclasse ou filha de veiculo

}

class Caminhao extends Veiculo{//Subclasse ou filha de veiculo


}

class Funcionario{



}

class Faxineiro extends Funcionario{

}

class Gerente extends Funcionario{

}

class Vendedor extends Funcionario{

}

class ClasseMae{
    
        void metodo1() {
            System.out.println("Metodo 1 Classe Mae");
        }
    
        void metodo2() {
            System.out.println("Metodo 2 Classe Mae");
        }
    
}

class ClasseFilha1 extends ClasseMae {

    @Override
    void metodo1() {
        System.out.println("Metodo 1 Classe Filha 1");
    }

}


class ClasseFilha2 extends ClasseMae {

    @Override
    void metodo1() {
        System.out.println("Metodo 1 Classe Filha 2");
    }

    @Override
    void metodo2() {
        System.out.println("Metodo 2 Classe Filha 2");
    }

}

//Exemplo de Associação Estrutural (envolve os atributos do objeto): 

class Endereco{

}

class Pessoa{ //nesse caso temos associação do tipo composição pois endereço só irá existir enquanto a pessoa existir, a pessoa é composta pelo endereço

    Endereco endereco;

}

class Aluno{

}

class Disciplina{ //nesse caso temos uma associação do tipo agregação, pois o aluno existe sem a disciplina por poder estar ligado a mais de uma disciplina

    Aluno aluno;

}

//Exemplo de Associação Comportamental (envolve os metodos):

class Cupom{

}

class Compra{ //nesse caso temos uma associação do tipo dependencia, pois o metodo finalizar da classe compra depende do Objeto Cupom

    void finalizar(Cupom cupom){

    }

}

//Exemplo de Interface

interface OperacaoMatematica{

    void soma(double a, double b);
    
    void subtracao(double a, double b);

    void multiplicacao(double a, double b);

    void divisao(double a, double b);

}

class Calculadora implements OperacaoMatematica{ //implementa todos os metodos da interface Operacao Matematica

    @Override
    public void soma(double a, double b){
        System.out.println("Soma: " + (a + b));
    }

    @Override
    public void subtracao(double a, double b){
        System.out.println("Subtração: " + (a-b) );
    }

    @Override
    public void multiplicacao(double a, double b){
        System.out.println("Multiplicação: " + (a*b));
    }

    @Override
    public void divisao(double a, double b){
        System.out.println("Divisão: " + (a/b));
    }


}


