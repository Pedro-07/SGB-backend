package com.biblioteca.livro.servicesImpl;

import java.util.List;
import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.biblioteca.livro.client.EmprestimoClient;
import com.biblioteca.livro.model.Livro;
import com.biblioteca.livro.repository.LivroRepository;
import com.biblioteca.livro.services.LivroService;

@Service
public class LivroServiceImpl implements LivroService{
	
	
    private LivroRepository livroRepository;

    public LivroServiceImpl(LivroRepository livroRepository) {
		super();
		this.livroRepository = livroRepository;
	}

	
	@Override
	public Livro cadastrar(Livro livro) {
		
		Livro repostaLivro = livroRepository.save(livro);
		
		return repostaLivro;
	}
	
	@Override
	public List<Livro> verLivros() {
		
		List<Livro> listarLivros = livroRepository.findAll();
		
		return listarLivros;
	}
	

	@Override
	public Livro editar(Long id, Livro livroAtualizado) {
	    Livro livroExistente = livroRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Livro não encontrado para edição"));

	    livroExistente.setTitulo(livroAtualizado.getTitulo());
	    livroExistente.setAutor(livroAtualizado.getAutor());
	    livroExistente.setEditora(livroAtualizado.getEditora());
	    livroExistente.setIsbn(livroAtualizado.getIsbn());
	    livroExistente.setAnoPubli(livroAtualizado.getAnoPubli());
	    livroExistente.setQuantidade(livroAtualizado.getQuantidade());

	    return livroRepository.save(livroExistente);
	}
	
	@Override
	public Livro buscarPorId(Long id) {
	    return livroRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
	}


	@Override
	public void deletar(Long idLivro) {
	    if (!livroRepository.existsById(idLivro)) {
	        throw new RuntimeException("Livro não encontrado: " + idLivro);
	    }
	    livroRepository.deleteById(idLivro);
	}

	
	@Override
    public List<Livro> buscarPorTitulo(String titulo) {
        return livroRepository.findByTituloIgnoreCase(titulo);
    }
	
	@Override
    public List<Livro> buscarLivrosPorTermo(String termo) {
        return livroRepository.findByTituloContainingIgnoreCase(termo);
    }
	
	@Override
	public boolean existsById(Long id) {
	    return livroRepository.existsById(id);
	}

	
}