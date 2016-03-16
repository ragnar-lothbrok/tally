package p1caccia.test;

import java.io.Serializable;

public class WordNode implements Serializable,Comparable<WordNode>{

	private static final long serialVersionUID = 1L;
	private String word;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public WordNode(String word) {
		super();
		this.word = word;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordNode other = (WordNode) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return word;
	}

	@Override
	public int compareTo(WordNode o) {
		return o.getWord().compareTo(this.getWord());
	}

}
