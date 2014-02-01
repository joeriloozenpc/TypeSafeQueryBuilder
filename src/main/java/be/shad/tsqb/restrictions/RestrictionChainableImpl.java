package be.shad.tsqb.restrictions;

import be.shad.tsqb.query.TypeSafeSubQuery;
import be.shad.tsqb.values.TypeSafeValue;

public abstract class RestrictionChainableImpl implements RestrictionChainable, RestrictionProvider {
	
	public abstract RestrictionImpl and();

	public abstract RestrictionImpl or();
	
	@Override
	public OnGoingTextRestriction and(String value) {
		return new OnGoingTextRestriction(and(), value);
	}

	@Override
	public OnGoingTextRestriction andt(TypeSafeValue<String> value) {
		return new OnGoingTextRestriction(and(), value);
	}

	@Override
	public OnGoingSubQueryTextRestriction andt(TypeSafeSubQuery<String> value) {
		return new OnGoingSubQueryTextRestriction(and(), value);
	}

	@Override
	public OnGoingNumberRestriction and(Number value) {
		return new OnGoingNumberRestriction(and(), value);
	}
	
	@Override
	public OnGoingNumberRestriction andn(TypeSafeValue<Number> value) {
		return new OnGoingNumberRestriction(and(), value);
	}
	
	@Override
	public OnGoingSubQueryNumberRestriction andn(TypeSafeSubQuery<Number> value) {
		return new OnGoingSubQueryNumberRestriction(and(), value);
	}

	@Override
	public OnGoingTextRestriction or(String value) {
		return new OnGoingTextRestriction(or(), value);
	}

	@Override
	public OnGoingTextRestriction ort(TypeSafeValue<String> value) {
		return new OnGoingTextRestriction(or(), value);
	}

	@Override
	public OnGoingSubQueryTextRestriction ort(TypeSafeSubQuery<String> value) {
		return new OnGoingSubQueryTextRestriction(or(), value);
	}

	@Override
	public OnGoingNumberRestriction or(Number value) {
		return new OnGoingNumberRestriction(or(), value);
	}
	
	@Override
	public OnGoingNumberRestriction orn(TypeSafeValue<Number> value) {
		return new OnGoingNumberRestriction(or(), value);
	}
	
	@Override
	public OnGoingSubQueryNumberRestriction orn(TypeSafeSubQuery<Number> value) {
		return new OnGoingSubQueryNumberRestriction(or(), value);
	}
	
}