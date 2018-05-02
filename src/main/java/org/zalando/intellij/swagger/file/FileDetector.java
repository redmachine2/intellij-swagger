package org.zalando.intellij.swagger.file;

import com.intellij.json.JsonLanguage;
import com.intellij.lang.Language;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.apache.commons.io.FilenameUtils;
import org.jetbrains.yaml.YAMLLanguage;
import org.zalando.intellij.swagger.traversal.path.PathFinder;

public class FileDetector {

    private static final String SWAGGER_KEY = "swagger";
    private static final String SWAGGER_VERSION = "2";
    private static final String OPEN_API_KEY = "openapi";
    private static final String OPEN_API_VERSION = "3";

    public boolean isMainSwaggerJsonFile(final PsiFile psiFile) {
        return hasJsonRootKey(psiFile, String.format("$.%s", SWAGGER_KEY), SWAGGER_VERSION);
    }

    public boolean isMainSwaggerYamlFile(final PsiFile psiFile) {
        return hasYamlRootKey(psiFile, String.format("$.%s", SWAGGER_KEY), SWAGGER_VERSION);
    }

    public boolean isMainOpenApiJsonFile(final PsiFile psiFile) {
        return hasJsonRootKey(psiFile, String.format("$.%s", OPEN_API_KEY), OPEN_API_VERSION);
    }

    public boolean isMainOpenApiYamlFile(final PsiFile psiFile) {
        return hasYamlRootKey(psiFile, String.format("$.%s", OPEN_API_KEY), OPEN_API_VERSION);
    }

    private boolean hasYamlRootKey(final PsiFile psiFile, final String lookupKey, final String lookupVersion) {
        final Language language = psiFile.getLanguage();
        if(!YAMLLanguage.INSTANCE.is(language)){
            return false;
        }
        return new PathFinder().findByPathFrom(lookupKey, psiFile)
                .filter(psiElement -> hasVersion(psiElement, lookupVersion)).isPresent();
    }

    private boolean hasJsonRootKey(final PsiFile psiFile, final String lookupKey, final String lookupVersion) {
        final Language language = psiFile.getLanguage();
        if(!JsonLanguage.INSTANCE.is(language)){
            return false;
        }
        return new PathFinder().findByPathFrom(lookupKey, psiFile)
                .filter(psiElement -> hasVersion(psiElement, lookupVersion)).isPresent();
    }

    private boolean hasVersion(final PsiElement psiElement, final String lookupVersion) {
        return psiElement.getLastChild().getText().contains(lookupVersion);
    }

    public boolean isMainSwaggerFile(final PsiFile file) {
        return isMainSwaggerJsonFile(file) || isMainSwaggerYamlFile(file);
    }

    public boolean isMainOpenApiFile(final PsiFile file) {
        return isMainOpenApiJsonFile(file) || isMainOpenApiYamlFile(file);
    }

    public boolean isSwaggerContentCompatible(VirtualFile file) {
        return FilenameUtils.isExtension(file.getName(),
                new String[]{FileConstants.JSON_FILE_EXTENSION,
                        FileConstants.YAML_FILE_EXTENSION,
                        FileConstants.YML_FILE_EXTENSION});
    }
}
