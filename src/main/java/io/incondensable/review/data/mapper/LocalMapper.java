package io.incondensable.review.data.mapper;

public interface LocalMapper<ENTITY, DOMAIN> {

    public DOMAIN mapEntityToDomain(ENTITY entity);

    public ENTITY mapDomainToEntity(DOMAIN domain);

}
