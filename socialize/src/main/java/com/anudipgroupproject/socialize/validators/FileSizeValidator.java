package com.anudipgroupproject.socialize.validators;

import java.io.File;

import com.anudipgroupproject.socialize.validators.annotations.FileSize;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FileSizeValidator implements ConstraintValidator<FileSize, File> {

	private long minSize;
	private long maxSize;

	@Override
	public void initialize(FileSize constraintAnnotation) {
		minSize = constraintAnnotation.min();
		maxSize = constraintAnnotation.max();
	}

	@Override
	public boolean isValid(File file, ConstraintValidatorContext context) {
		if (file == null || file.exists()) {
			return true; // Empty file is considered valid
		}
		
		boolean condition = minSize <= file.length() && file.length() <= maxSize;
		
		return condition;
	}
}
