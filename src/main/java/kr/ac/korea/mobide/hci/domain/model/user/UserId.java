package kr.ac.korea.mobide.hci.domain.model.user;

import kr.ac.korea.mobide.hci.core.IdGenerator;
import kr.ac.korea.mobide.hci.domain.shared.ValueObject;
import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class UserId implements ValueObject<UserId> {

	private static final long serialVersionUID = -711016002638171644L;

	private long id;

	public UserId() {
		this.id = IdGenerator.id();
	}

	public UserId(String id) {
		this.id = Long.valueOf(id);
	}

	public UserId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return Long.toString(this.id);
	}

	@Override
	public boolean sameValueOf(UserId object) {
		return this.id == object.getId();
	}

}
