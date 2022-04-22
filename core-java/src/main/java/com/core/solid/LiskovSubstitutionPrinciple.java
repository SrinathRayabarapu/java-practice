package com.core.solid;

/**
 * LSP is an important part of SOLID principle which specified that you should design your classes so that
 * client dependencies can be substituted with subclasses without the client knowing about the change.
 *
 * @author Srinath.Rayabarapu
 */
public class LiskovSubstitutionPrinciple {

    class Rectangle {

        private double height;
        private double width;

        public void setHeight(double height) {
            //ignore
        }

        public void setWidth(double width) {
            //ignore
        }
    }

    class Square extends Rectangle {

        @Override
        public void setHeight(double height) {
            super.setHeight(height);
            super.setWidth(height);
        }

        @Override
        public void setWidth(double width) {
            setHeight(width);
        }
    }

}
