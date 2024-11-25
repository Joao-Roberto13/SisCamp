package SisCamp_desktop;

public class Pesquisa {

	public Pesquisa() {

	}

	public int pesquisar(String nome) {
		int tam= Tarefas.vetor.size();
		Arbitro a;
		Clube b;
		Campeonato c;
		Jogador j;

		for(int i = 0; i<tam; i++)
		{
			if(Tarefas.vetor.elementAt(i) instanceof Arbitro)
			{
				a = (Arbitro) Tarefas.vetor.elementAt(i);
				if(a.getNome().equalsIgnoreCase(nome))
					return i;
			}
		}

		for(int i = 0; i<tam; i++)
		{
			if(Tarefas.vetor.elementAt(i) instanceof Clube)
			{
				b = (Clube) Tarefas.vetor.elementAt(i);
				if(b.getNome().equalsIgnoreCase(nome))
					return i;
			}
		}

		for(int i = 0; i<tam; i++)
		{
			if(Tarefas.vetor.elementAt(i) instanceof Campeonato)
			{
				c = (Campeonato) Tarefas.vetor.elementAt(i);
				if(c.getTitulo().equalsIgnoreCase(nome))
					return i;
			}
		}

		for(int i = 0; i<tam; i++)
		{
			if(Tarefas.vetor.elementAt(i) instanceof Jogador)
			{
				j = (Jogador) Tarefas.vetor.elementAt(i);
				if(j.getNome().equalsIgnoreCase(nome))
					return i;
			}
		}
		return -1;
	}

}
