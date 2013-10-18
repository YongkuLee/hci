package kr.ac.korea.mobide.hci.domain.shared;

public interface EntityModel<E> {

	boolean sameEntityAs(E model);

}
