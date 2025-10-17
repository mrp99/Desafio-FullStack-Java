package br.com.juridico.totvs.fullstack.Backend.excptions;

public class RecursoNaoEncontradoException  extends RuntimeException{
    public RecursoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
