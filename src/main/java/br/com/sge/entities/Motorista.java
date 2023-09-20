	package br.com.sge.entities;
	
	import java.io.Serializable;
	import java.util.Objects;
	
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
	import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
	
	@Entity
	@Table(name = "tb_motorista")
	public class Motorista implements Serializable{
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String nome;
		private String CNH;
		private String CPF;
		private String endereco;
		private String telefone;
		private String email;
		
		@OneToMany
		@JoinColumn(name = "id_veiculo_fk")
		private Veiculo veiculo;
		
		public Motorista() {
			
		}
	
		public Motorista(Long id, String nome, String CNH, String CPF, String endereco, String telefone, String email, Veiculo veiculo) {
	
			this.id = id;
			this.nome = nome;
			this.CNH = CNH;
			this.CPF = CPF;
			this.endereco = endereco;
			this.telefone = telefone;
			this.email = email;
			this.veiculo = veiculo;
		}
	
		public Long getId() {
			return id;
		}
	
		public void setId(Long id) {
			this.id = id;
		}
	
		public String getNome() {
			return nome;
		}
	
		public void setNome(String nome) {
			this.nome = nome;
		}
	
		public String getCNH() {
			return CNH;
		}
	
		public void setCNH(String CNH) {
			this.CNH = CNH;
		}
	
		public String getCPF() {
			return CPF;
		}
	
		public void setCPF(String CPF) {
			this.CPF = CPF;
		}
	
		public String getEndereco() {
			return endereco;
		}
	
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
	
		public String getTelefone() {
			return telefone;
		}
	
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
	
		public String getEmail() {
			return email;
		}
	
		public void setEmail(String email) {
			this.email = email;
		}
		
		public Veiculo getVeiculo() {
			return veiculo;
		}
	
		public void setVeiculo(Veiculo veiculo) {
			this.veiculo = veiculo;
		}
		
		
	
		@Override
		public int hashCode() {
			return Objects.hash(CPF, email, endereco, id, nome, telefone, CNH);
		}
	
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Motorista other = (Motorista) obj;
			return Objects.equals(CPF, other.CPF) && Objects.equals(email, other.email)
					&& Objects.equals(endereco, other.endereco) && Objects.equals(id, other.id)
					&& Objects.equals(nome, other.nome) && Objects.equals(telefone, other.telefone)
					&& Objects.equals(CNH, other.CNH);
		}
		
		
	}
