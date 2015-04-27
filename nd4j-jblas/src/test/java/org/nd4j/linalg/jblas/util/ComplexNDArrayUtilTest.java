package org.nd4j.linalg.jblas.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.nd4j.linalg.api.complex.IComplexNDArray;
import org.nd4j.linalg.api.complex.IComplexNumber;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.indexing.NDArrayIndex;
import org.nd4j.linalg.util.ComplexNDArrayUtil;

/**
 * Created by agibsoncccc on 4/25/15.
 */
public class ComplexNDArrayUtilTest {

    @Test
    public void testTruncate() {
        IComplexNDArray truncate = Nd4j.createComplex(5,5);
        IComplexNDArray truncated = ComplexNDArrayUtil.truncate(truncate, 3, 0);
        IComplexNDArray assertion = Nd4j.createComplex(3,5);
        assertEquals(assertion,truncated);
    }

    @Test
    public void testPadWithZeros() {
        IComplexNDArray matrix = Nd4j.complexLinSpace(1,8,8).reshape(2,4);
        IComplexNDArray padded = ComplexNDArrayUtil.padWithZeros(matrix,new int[]{2,5});
        NDArrayIndex[] fill = NDArrayIndex.createCoveringShape(matrix.shape());
        IComplexNDArray assertion = Nd4j.createComplex(2,5);
        assertion.put(fill,matrix);
        assertEquals(assertion,padded);

    }

    @Test
    public void testPadWithZerosOffset() {
        IComplexNDArray matrix = Nd4j.complexLinSpace(1,8,8).reshape(2,4);
        IComplexNDArray slice = matrix.slice(1);
        IComplexNDArray padded = ComplexNDArrayUtil.padWithZeros(slice,new int[]{2,5});
        NDArrayIndex[] fill = NDArrayIndex.createCoveringShape(matrix.shape());
        IComplexNDArray assertion = Nd4j.createComplex(2,5);
        assertion.put(fill,slice);
        assertEquals(assertion,padded);



    }

    @Test
    public void testCenter() {
        IComplexNDArray linspaced = Nd4j.complexLinSpace(1,100,100).reshape(10,10);
        IComplexNDArray centered = ComplexNDArrayUtil.center(linspaced,new int[]{5,5});
        IComplexNDArray assertion = Nd4j.createComplex(5,5);
        IComplexNDArray linspaced2 = Nd4j.createComplex(new IComplexNumber[]{
                Nd4j.createComplexNumber(20,0),
                Nd4j.createComplexNumber(30,0),
                Nd4j.createComplexNumber(40,0),
                Nd4j.createComplexNumber(50,0),
                Nd4j.createComplexNumber(60,0),


        });


        int count = 3;
        for(int i = 0; i < assertion.rows(); i++) {
            assertion.putRow(i,linspaced2.add(count++));
        }
        assertEquals(assertion,centered);

    }

}
