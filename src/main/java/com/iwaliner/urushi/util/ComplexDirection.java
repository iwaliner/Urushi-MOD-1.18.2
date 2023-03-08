package com.iwaliner.urushi.util;

public  enum ComplexDirection {
    N(0),
    N_NE(1),
    NE(2),
    E_NE(3),
    E(4),
    E_SE(5),
    SE(6),
    S_SE(7),
    S(8),
    S_SW(9),
    SW(10),
    W_SW(11),
    W(12),
    W_NW(13),
    NW(14),
    N_NW(15),
    FAIL(-1);

    private int id;

    private ComplexDirection(int id) {
        this.id = id;
    }
    public int getID()
    {
        return this.id;
    }
}
