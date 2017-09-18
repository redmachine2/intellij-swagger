package org.zalando.intellij.swagger.traversal.path.openapi;

import com.intellij.psi.PsiElement;
import org.zalando.intellij.swagger.traversal.path.PathFinder;

public interface PathResolver {

    boolean childOfRoot(PsiElement psiElement);

    boolean childOfInfo(PsiElement psiElement);

    boolean childOfContact(PsiElement psiElement);

    boolean childOfLicense(PsiElement psiElement);

    boolean childOfPath(PsiElement psiElement);

    boolean childOfOperation(PsiElement psiElement);

    boolean childOfExternalDocs(PsiElement psiElement);

    boolean childOfParameters(PsiElement psiElement);

    boolean childOfParameterItems(PsiElement psiElement);

    boolean childOfResponses(PsiElement psiElement);

    boolean childOfResponse(PsiElement psiElement);

    boolean childOfResponseDefinition(PsiElement psiElement);

    boolean childOfHeader(PsiElement psiElement);

    boolean childOfHeaders(PsiElement psiElement);

    boolean childOfTag(PsiElement psiElement);

    boolean childOfSecurityDefinition(PsiElement psiElement);

    boolean childOfSchema(PsiElement psiElement);

    boolean childOfSchemaItems(PsiElement psiElement);

    default boolean childOfPropertiesSchema(PsiElement psiElement) {
        return false;
    }

    default boolean childOfAdditionalProperties(PsiElement psiElement) {
        return false;
    }

    boolean childOfXml(PsiElement psiElement);

    boolean childOfDefinitions(PsiElement psiElement);

    boolean childOfParameterDefinition(PsiElement psiElement);

    boolean isMimeValue(PsiElement psiElement);

    boolean isSchemesValue(PsiElement psiElement);

    boolean isTagsValue(PsiElement psiElement);

    boolean isSchemaRefValue(PsiElement psiElement);

    boolean isParameterRefValue(PsiElement psiElement);

    boolean isResponseRefValue(PsiElement psiElement);

    boolean childOfRootSecurityKey(PsiElement psiElement);

    boolean childOfOperationSecurityKey(PsiElement psiElement);

    boolean isSecurityScopeNameValue(PsiElement psiElement);

    boolean childOfItemsCollectionFormat(PsiElement psiElement);

    boolean childOfParametersCollectionFormat(PsiElement psiElement);

    boolean childOfHeadersCollectionFormat(PsiElement psiElement);

    default boolean hasPath(final PsiElement psiElement, final String pathExpression) {
        return new PathFinder().isInsidePath(psiElement, pathExpression);
    }

    default boolean childOfServer(PsiElement psiElement) {
        return false;
    }

    default boolean childOfServerVariable(PsiElement psiElement) {
        return false;
    }

    default boolean childOfComponent(PsiElement psiElement) {
        return false;
    }

    default boolean childOfRequestBody(PsiElement psiElement) {
        return false;
    }

    default boolean childOfMediaType(PsiElement psiElement) {
        return false;
    }

    default boolean childOfExample(PsiElement psiElement) {
        return false;
    }

    default boolean childOfEncoding(PsiElement psiElement) {
        return false;
    }

    default boolean childOfLink(PsiElement psiElement) {
        return false;
    }

    default boolean childOfCallback(PsiElement psiElement) {
        return false;
    }

    default boolean childOfSecurityScheme(PsiElement psiElement) {
        return false;
    }

    default boolean childOfContent(PsiElement psiElement) {
        return false;
    }

    default boolean isExampleRefValue(PsiElement psiElement) {
        return false;
    }

    default boolean isRequestBodyRefValue(PsiElement psiElement) {
        return false;
    }

    default boolean isHeaderRefValue(PsiElement psiElement) {
        return false;
    }

    default boolean isLinkRefValue(PsiElement psiElement) {
        return false;
    }

    default boolean isCallbackRefValue(PsiElement psiElement) {
        return false;
    }

    default boolean isBooleanValue(PsiElement psiElement) {
        return false;
    }

    default boolean isTypeValue(PsiElement psiElement) {
        return false;
    }

    default boolean isInValue(PsiElement psiElement) {
        return false;
    }

    default boolean isFormatValue(PsiElement psiElement) {
        return false;
    }

    default boolean isStyleValue(PsiElement psiElement) {
        return false;
    }
}