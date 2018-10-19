package com.kafang.atgo.persistence.db.base.entity;

import java.util.List;
import java.util.Optional;

public final class OneToManyEntity<O extends SimpleEntity, M extends SimpleEntity> implements MappingEntity {

	Optional<O> o;

	Optional<List<M>> mList;

	public OneToManyEntity(O o, List<M> mList) {
		super();
		this.o = Optional.ofNullable(o);
		this.mList = Optional.ofNullable(mList);
	}

	public Optional<O> getOneEntity() {
		return o;
	}

	public Optional<List<M>> getManyEntity() {
		return mList;
	}

}
