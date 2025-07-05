package com.pp.sun.modifires;

import com.pp.sun.modifires.child.ChildPackage;

public class AccessModifileCaller {

    public static void main(String[] args) {

        SamePackageClass samePackageClass = new SamePackageClass();
        samePackageClass.protectedMethodInSameClass();
        samePackageClass.DefaultMethodInSameClass();
        ChildPackage childPackage = new ChildPackage();
//        childPackage.protectedMethodInChildClass(); // error
    }


}
