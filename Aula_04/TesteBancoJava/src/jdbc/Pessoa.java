package jdbc;

public class Pessoa {
		
		private int codigo;
		private String nome;
		
	/*Criacao do metodo construtor*/		
	public Pessoa(int codigo, String nome) {
			super();
			this.codigo = codigo;
			this.nome = nome;
		}
	
	/* Criacao dos metodos Get e Set*/	
		public int getCodigo() {
			return codigo;
		}
		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		
				

}
