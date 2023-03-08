package com.iwaliner.urushi.util;

public  enum ElementType {
    WoodElement(0),
    FireElement(1),
    EarthElement(2),
    MetalElement(3),
    WaterElement(4),
    FAIL(-1);

        private int id;

        private ElementType(int id) {
            this.id = id;
        }
        public static ElementType getType(int id){
            if(id==0){
                return WoodElement;
            }else if(id==1){
                return FireElement;
            }else if(id==2){
                return EarthElement;
            }else if(id==3){
                return MetalElement;
            }else if(id==4){
                return WaterElement;
            }else{
                return ElementType.FAIL;
            }
        }
        public int getID()
        {
            return this.id;
        }
    }

