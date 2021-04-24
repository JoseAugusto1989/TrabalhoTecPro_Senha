package Senha;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import Entities.Senha;
import View.SenhaView;

public class StartApp01 {
	
	static Scanner scan = new Scanner(System.in);
	static Senha senha = new Senha();
	static SenhaView view = new SenhaView();
	static String passw = " ";
	static String[] caract;
	static String local = null;
	static int tamanhoSenha = 0;
	
	public static void main(String[] args) {
		
		programa();
		
		scan.close();
	}
	
	private static void programa() {
		view.printMenu();    //mount the menu
		view.printMenu1();
			senha.setTamanhoMin(readInteger());
		view.printMenu2();
			senha.setTamanhoMax(readInteger());
				tamanhoSenha();    //deal of the length of the password you enter is wrong
		view.printMenu3();
			senha.setSenhaMaiusc(scan.nextLine());    //capital letters
				instruSenhaMaius();		
		view.printMenu4();
			senha.setSenhaMinusc(scan.nextLine());    //tiny letters
				instruSenhaMinus();		
		view.printMenu5();
			senha.setNumeroSenha(scan.nextLine());    //number
				instruSenhaNumeros();
		view.printMenu6();
			senha.setCaracEspe(scan.nextLine());	//character especial
				instruSenhaCaracEspec();
		
				instruGerarSenha();
				gerarSenha();
	}
	
    private static void tamanhoSenha() {
		if (senha.getTamanhoMin() >= senha.getTamanhoMax()) {
				view.printMenu1();
					senha.setTamanhoMin(readInteger());
				view.printMenu2();
					senha.setTamanhoMax(readInteger());
						tamanhoSenha();		
		}
		
	}
	
	private static void instruGerarSenha() {
		System.out.println("Sua senha deve ser entre " + senha.getTamanhoMin() + " e " + senha.getTamanhoMax() + " caracteres");
		System.out.println("A senha " + senha.getSenhaMaiusc() + ", deverá conter letras MAIÚSCULAS");
		System.out.println("A senha " + senha.getSenhaMinusc() + ", deverá conter letras MINÚSCULAS");
		System.out.println("A senha " + senha.getNumeroSenha() + ", deverá ter números ");
		System.out.println("A senha " + senha.getCaracEspe() + ", deverá ter caractéres especiais");
	}
		
	private static void instruSenhaMaius() {
		if (senha.getSenhaMaiusc().equalsIgnoreCase("Sim")) {
			view.printMenu9();
					
		} else if (senha.getSenhaMaiusc().equalsIgnoreCase("Nao")) {
			view.printMenu17(); 
					
		} else {
			view.printMenu11();
				senha.setSenhaMaiusc(scan.nextLine());
					instruSenhaMaius();
		}
		
	}
	
	private static void instruSenhaMinus() {
		if (senha.getSenhaMinusc().equalsIgnoreCase("Nao")) {
			view.printMenu10();
			
		} else if (senha.getSenhaMinusc().equalsIgnoreCase("Sim")) {
			view.printMenu16();
			
		} else {
			view.printMenu11();
				senha.setSenhaMinusc(scan.nextLine());
					instruSenhaMinus();
		}
		
	}
	
	private static void instruSenhaNumeros() {
		if (senha.getNumeroSenha().equalsIgnoreCase("Sim")) {
			view.printMenu12();
				
		} else if (senha.getNumeroSenha().equalsIgnoreCase("Nao")) {
			view.printMenu13();
				
		} else {
			view.printMenu11();
				senha.setNumeroSenha(scan.nextLine());
					instruSenhaNumeros();		
		}
		
	}
	
	private static void instruSenhaCaracEspec() {
		if (senha.getCaracEspe().equalsIgnoreCase("Sim")) {
			view.printMenu15();
				
		} else if (senha.getCaracEspe().equalsIgnoreCase("Nao")) {
			view.printMenu14();
				
		} else {
			view.printMenu11();
				senha.setCaracEspe(scan.nextLine());
					instruSenhaCaracEspec();
		}
		
	}
	
	private static void gerarSenha() {
		if (senha.getSenhaMaiusc().equalsIgnoreCase("SIM")&& senha.getSenhaMinusc().equalsIgnoreCase("SIM")&& 
			senha.getNumeroSenha().equalsIgnoreCase("SIM")&& senha.getCaracEspe().equalsIgnoreCase("SIM")) {
			caract = new String[]  {"0","1","2","3","4","5","6","7","8","9",
				"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
				"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
				"!","@","#","$","%","&","*"};
			
		} else if (senha.getSenhaMaiusc().equalsIgnoreCase("SIM")&& senha.getSenhaMinusc().equalsIgnoreCase("SIM")&& 
			senha.getNumeroSenha().equalsIgnoreCase("SIM")&& senha.getCaracEspe().equalsIgnoreCase("NAO")) {
			caract = new String[]  {"0","1","2","3","4","5","6","7","8","9",
				"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
				"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
			
		} else if (senha.getSenhaMaiusc().equalsIgnoreCase("SIM")&& senha.getSenhaMinusc().equalsIgnoreCase("SIM")&& 
			senha.getNumeroSenha().equalsIgnoreCase("NAO")&& senha.getCaracEspe().equalsIgnoreCase("SIM")) {
			caract = new String[]  {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
				"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
				"!","@","#","$","%","&","*"};
			
		} else if (senha.getSenhaMaiusc().equalsIgnoreCase("SIM")&& senha.getSenhaMinusc().equalsIgnoreCase("NAO")&& 
			senha.getNumeroSenha().equalsIgnoreCase("SIM")&& senha.getCaracEspe().equalsIgnoreCase("SIM")) {
			caract = new String[]  {"0","1","2","3","4","5","6","7","8","9",
				"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
				"!","@","#","$","%","&","*"};
			
		} else if (senha.getSenhaMaiusc().equalsIgnoreCase("NAO")&& senha.getSenhaMinusc().equalsIgnoreCase("SIM")&& 
			senha.getNumeroSenha().equalsIgnoreCase("SIM")&& senha.getCaracEspe().equalsIgnoreCase("SIM")) {
			caract = new String[]  {"0","1","2","3","4","5","6","7","8","9",
				"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
				"!","@","#","$","%","&","*"};
			
		} else if (senha.getSenhaMaiusc().equalsIgnoreCase("SIM")&& senha.getSenhaMinusc().equalsIgnoreCase("SIM")&& 
			senha.getNumeroSenha().equalsIgnoreCase("NAO")&& senha.getCaracEspe().equalsIgnoreCase("NAO")) {
			caract = new String[]  {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
				"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};	
			
		} else if (senha.getSenhaMaiusc().equalsIgnoreCase("SIM")&& senha.getSenhaMinusc().equalsIgnoreCase("NAO")&& 
			senha.getNumeroSenha().equalsIgnoreCase("SIM")&& senha.getCaracEspe().equalsIgnoreCase("NAO")) {
			caract = new String[]  {"0","1","2","3","4","5","6","7","8","9",
				"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
			
		} else if (senha.getSenhaMaiusc().equalsIgnoreCase("NAO")&& senha.getSenhaMinusc().equalsIgnoreCase("SIM")&& 
			senha.getNumeroSenha().equalsIgnoreCase("SIM")&& senha.getCaracEspe().equalsIgnoreCase("NAO")) {
			caract = new String[]  {"0","1","2","3","4","5","6","7","8","9",
				"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
			
		} else if (senha.getSenhaMaiusc().equalsIgnoreCase("SIM")&& senha.getSenhaMinusc().equalsIgnoreCase("NAO")&& 
			senha.getNumeroSenha().equalsIgnoreCase("NAO")&& senha.getCaracEspe().equalsIgnoreCase("SIM")) {
			caract = new String[]  {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
				"!","@","#","$","%","&","*"};
			
		} else if (senha.getSenhaMaiusc().equalsIgnoreCase("NAO")&& senha.getSenhaMinusc().equalsIgnoreCase("SIM")&& 
			senha.getNumeroSenha().equalsIgnoreCase("NAO")&& senha.getCaracEspe().equalsIgnoreCase("SIM")) {
			caract = new String[]  {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
				"!","@","#","$","%","&","*"};
			
		} else if (senha.getSenhaMaiusc().equalsIgnoreCase("NAO")&& senha.getSenhaMinusc().equalsIgnoreCase("NAO")&& 
			senha.getNumeroSenha().equalsIgnoreCase("SIM")&& senha.getCaracEspe().equalsIgnoreCase("SIM")) {
			caract = new String[]  {"0","1","2","3","4","5","6","7","8","9",
				"!","@","#","$","%","&","*"};
			
		} else if (senha.getSenhaMaiusc().equalsIgnoreCase("SIM")&& senha.getSenhaMinusc().equalsIgnoreCase("NAO")&& 
			senha.getNumeroSenha().equalsIgnoreCase("NAO")&& senha.getCaracEspe().equalsIgnoreCase("NAO")) {
			caract = new String[]  {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
			
		} else if (senha.getSenhaMaiusc().equalsIgnoreCase("NAO")&& senha.getSenhaMinusc().equalsIgnoreCase("SIM")&& 
			senha.getNumeroSenha().equalsIgnoreCase("NAO")&& senha.getCaracEspe().equalsIgnoreCase("NAO")) {
			caract = new String[]  {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
			
		} else if (senha.getSenhaMaiusc().equalsIgnoreCase("NAO")&& senha.getSenhaMinusc().equalsIgnoreCase("NAO")&& 
			senha.getNumeroSenha().equalsIgnoreCase("SIM")&& senha.getCaracEspe().equalsIgnoreCase("NAO")) {
			caract = new String[]  {"0","1","2","3","4","5","6","7","8","9"};
			
		} else if (senha.getSenhaMaiusc().equalsIgnoreCase("NAO")&& senha.getSenhaMinusc().equalsIgnoreCase("NAO")&& 
			senha.getNumeroSenha().equalsIgnoreCase("NAO")&& senha.getCaracEspe().equalsIgnoreCase("SIM")) {
			caract = new String[]  {"!","@","#","$","%","&","*"};
			
		} else if (senha.getSenhaMaiusc().equalsIgnoreCase("NAO")&& senha.getSenhaMinusc().equalsIgnoreCase("NAO")&& 
			senha.getNumeroSenha().equalsIgnoreCase("NAO")&& senha.getCaracEspe().equalsIgnoreCase("NAO")) {
				System.out.println("\nVocê não gerou nenhuma senha!\n");
					programa();
		}
		printSenha();
	}
	
	private static int readInteger() {
		int value = scan.nextInt();    scan.nextLine();
		return value;
	}
	
	private static void printSenha() {
		
		for (int i=senha.getTamanhoMin(); i<=senha.getTamanhoMax(); i++) {
			 int j =  (int) (Math.random() * caract.length);
			 passw += caract[j];
		    
		}
		System.out.println("\nA SENHA GERADA É: " + passw + "\n");
		salvandoSenhaTxt();
		
	}

	private static void salvandoSenhaTxt() {
		writeText("secret_password.txt", passw);
		
	}
	
	private static void writeText(String pathFile, String readText) {
		try (FileWriter creatorFile = new FileWriter(pathFile, true);
			 BufferedWriter buffer = new BufferedWriter(creatorFile);
		   	 PrintWriter writerFile = new PrintWriter(creatorFile);
				) {
				
				writerFile.append(readText);
				System.out.println("Arquivo salvo com sucesso!");
				
			} catch (IOException e){
				e.printStackTrace();
			}
			
		}
		
	}

