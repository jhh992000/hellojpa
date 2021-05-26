package hellojpa.entity;

import javax.persistence.*;

@Entity
public class Member {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "USERNAME", nullable = true, length = 20)
	private String name;

	private int age;
	@Enumerated(EnumType.STRING) //절대 ORDINAL 써선 안된다. 나중에 enum 변경시 값(순서번호)이 꼬일 수 있다.
	private MemberType memberType;

	@Lob
	private String clobString;

	@Lob
	private byte[] blobString;

	@Transient
	private String hiddenFieldString;

	public String getHiddenFieldString() {
		return hiddenFieldString;
	}

	public void setHiddenFieldString(String hiddenFieldString) {
		this.hiddenFieldString = hiddenFieldString;
	}

	public String getClobString() {
		return clobString;
	}

	public void setClobString(String clobString) {
		this.clobString = clobString;
	}

	public byte[] getBlobString() {
		return blobString;
	}

	public void setBlobString(byte[] blobString) {
		this.blobString = blobString;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public MemberType getMemberType() {
		return memberType;
	}

	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}
}
