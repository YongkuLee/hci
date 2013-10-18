package kr.ac.korea.mobide.hci.domain.shared;

import java.io.Serializable;

public interface ValueObject<V> extends Serializable {

	boolean sameValueOf(V object);

}
