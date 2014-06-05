//: annotations/database/TableCreationProcessorFactory.java
// The database example using Visitor.
// {Exec: apt -factory
// annotations.database.TableCreationProcessorFactory
// database/Member.java -s database}
package net.minixalpha.chap20.database;

import com.sun.mirror.apt.*;
import com.sun.mirror.declaration.*;
import com.sun.mirror.type.DeclaredType;
import com.sun.mirror.util.*;
import net.minixalpha.chap20.*;
import java.util.*;

import javax.annotation.processing.Completion;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

import static com.sun.mirror.util.DeclarationVisitors.*;

public class TableCreationProcessorFactory implements Processor {
	public Processor getProcessorFor(Set<TypeElement> atds,
			ProcessingEnvironment env) {
		return new TableCreationProcessor(env);
	}

	public Collection<String> supportedAnnotationTypes() {
		return Arrays.asList("annotations.database.DBTable",
				"annotations.database.Constraints",
				"annotations.database.SQLString",
				"annotations.database.SQLInteger");
	}

	public Collection<String> supportedOptions() {
		return Collections.emptySet();
	}

	private static class TableCreationProcessor implements Processor {
		private final ProcessingEnvironment env;
		private String sql = "";

		public TableCreationProcessor(ProcessingEnvironment env) {
			this.env = env;
		}

		public void process() {
			javax.lang.model.util.Types types = env.getTypeUtils();
			TypeElement typeElem;
			TypeMirror typeArgs;

			// for (TypeElement typeDecl : types.getDeclaredType(typeElem,
			// typeArgs)) {
			// typeDecl.accept(getDeclarationScanner(
			// new TableCreationVisitor(), NO_OP));
			// sql = sql.substring(0, sql.length() - 1) + ");";
			// System.out.println("creation SQL is :\n" + sql);
			// sql = "";
			// }
		}

		private class TableCreationVisitor extends SimpleDeclarationVisitor {
			public void visitClassDeclaration(ClassDeclaration d) {
				DBTable dbTable = d.getAnnotation(DBTable.class);
				if (dbTable != null) {
					sql += "CREATE TABLE ";
					sql += (dbTable.name().length() < 1) ? d.getSimpleName()
							.toUpperCase() : dbTable.name();
					sql += " (";
				}
			}

			public void visitFieldDeclaration(FieldDeclaration d) {
				String columnName = "";
				if (d.getAnnotation(SQLInteger.class) != null) {
					SQLInteger sInt = d.getAnnotation(SQLInteger.class);
					// Use field name if name not specified
					if (sInt.name().length() < 1)
						columnName = d.getSimpleName().toUpperCase();
					else
						columnName = sInt.name();
					sql += "\n    " + columnName + " INT"
							+ getConstraints(sInt.constraints()) + ",";
				}
				if (d.getAnnotation(SQLString.class) != null) {
					SQLString sString = d.getAnnotation(SQLString.class);
					// Use field name if name not specified.
					if (sString.name().length() < 1)
						columnName = d.getSimpleName().toUpperCase();
					else
						columnName = sString.name();
					sql += "\n    " + columnName + " VARCHAR("
							+ sString.value() + ")"
							+ getConstraints(sString.constraints()) + ",";
				}
				if (d.getAnnotation(SQLChar.class) != null) {
					SQLChar cChar = d.getAnnotation(SQLChar.class);
					// Use field name if name not specified.
					if (cChar.name().length() < 1)
						columnName = d.getSimpleName().toUpperCase();
					else
						columnName = cChar.name();
					sql += "\n    " + columnName + " VARCHAR(" + cChar.value()
							+ ")" + getConstraints(cChar.constraints()) + ",";
				}
			}

			private String getConstraints(Constraints con) {
				String constraints = "";
				if (!con.allowNull())
					constraints += " NOT NULL";
				if (con.primaryKey())
					constraints += " PRIMARY KEY";
				if (con.unique())
					constraints += " UNIQUE";
				return constraints;
			}
		}

		@Override
		public Set<String> getSupportedOptions() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Set<String> getSupportedAnnotationTypes() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SourceVersion getSupportedSourceVersion() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void init(ProcessingEnvironment processingEnv) {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean process(Set<? extends TypeElement> annotations,
				RoundEnvironment roundEnv) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterable<? extends Completion> getCompletions(Element element,
				AnnotationMirror annotation, ExecutableElement member,
				String userText) {
			// TODO Auto-generated method stub
			return null;
		}
	}

	@Override
	public Set<String> getSupportedOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getSupportedAnnotationTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SourceVersion getSupportedSourceVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ProcessingEnvironment processingEnv) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<? extends Completion> getCompletions(Element element,
			AnnotationMirror annotation, ExecutableElement member,
			String userText) {
		// TODO Auto-generated method stub
		return null;
	}
} // /:~
