package net.azib.java.students.t104540.hometask8;

import org.antlr.stringtemplate.test.TestStringTemplate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class SimpleCopyProgramTest extends  AbstractCopyProgramTest{
	public SimpleCopyProgramTest() {
		super(new SimpleCopyProgram());
	}
}
