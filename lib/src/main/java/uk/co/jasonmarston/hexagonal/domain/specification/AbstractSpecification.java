package uk.co.jasonmarston.hexagonal.domain.specification;

public non-sealed abstract class AbstractSpecification<T> implements Specification<T> {
	@Override
	public final Specification<T> and(final Specification<T> other) {
		return new AndSpecification<T>(this, other);
	}

	@Override
	public final Specification<T> or(final Specification<T> other) {
		return new OrSpecification<T>(this, other);
	}

	@Override
	public final Specification<T> xor(final Specification<T> other) {
		return new XorSpecification<T>(this, other);
	}

	@Override
	public final Specification<T> not() {
		return new NotSpecification<T>(this);
	}

	@Override
	public final Specification<T> nand(final Specification<T> other) {
		return new NandSpecification<T>(this, other);
	}

	@Override
	public final Specification<T> nor(final Specification<T> other) {
		return new NorSpecification<T>(this, other);
	}

	@Override
	public final Specification<T> nxor(final Specification<T> other) {
		return new NxorSpecification<T>(this, other);
	}
}
