package uk.co.jasonmarston.hexagonal.domain.specification;

@SuppressWarnings("unused")
public class EqualsSpecification extends AbstractSpecification<String> {
    @Override
    public boolean isSatisfiedBy(final String candidate) {
        return false;
    }
}
