//package br.com.sge.services.validation;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import br.com.sge.entities.AdministradorInsertDTO;
//import br.com.sge.repositories.ClienteRepository;
//import jakarta.validation.ConstraintValidator;
//
//public class ClienteInsertValidator implements ConstraintValidator<UsuarioInsertValid, AdministradorInsertDTO> {
//	
//	@Autowired
//	private ClienteRepository repository;
//	
////	@Override
////	public void initialize(UsuarioInsertValid ann) {
////	}
////
////	@Override
////	public boolean isValid(AdministradorInsertDTO dto, ConstraintValidatorContext context) {
////		
////		List<FieldMessage> list = new ArrayList<>();
////		
////		// Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista
////		Cliente associado = repository.findByEmail(dto.getEmail());
////		if(associado != null) {
////			list.add(new FieldMessage("email","O email Informado ja Existe no sistema"));
////		}
////		
////		for (FieldMessage e : list) {
////			context.disableDefaultConstraintViolation();
////			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
////					.addConstraintViolation();
////		}
////		return list.isEmpty();
////	}
//}