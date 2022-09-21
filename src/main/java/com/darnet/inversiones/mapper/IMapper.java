package com.darnet.inversiones.mapper;

public interface IMapper <I, O>{
    public O map(I in);
}
