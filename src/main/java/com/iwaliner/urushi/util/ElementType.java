package com.iwaliner.urushi.util;

public  enum ElementType {
    WoodElement(0),
    FireElement(1),
    EarthElement(2),
    MetalElement(3),
    WaterElement(4);

        private int id;

        private ElementType(int id) {
            this.id = id;
        }
        public int getID()
        {
            return this.id;
        }
    }

