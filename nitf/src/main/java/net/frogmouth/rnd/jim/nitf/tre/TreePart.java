package net.frogmouth.rnd.jim.nitf.tre;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import javafx.scene.control.TreeItem;

/**
 * Abstract element of something that can appear in the tree display.
 *
 * <p>This includes all TREs, but can include nested structures too.
 */
public abstract class TreePart {

    /**
     * Get the label for this tree part.
     *
     * @return human readable label for this tree part.
     */
    protected abstract String getTreeItemLabel();

    /**
     * Convert this item into a TreeItem.
     *
     * @return a TreeItem for this part.
     */
    public TreeItem<String> toTreeItem() {
        TreeItem<String> treeItem = new TreeItem<>(getTreeItemLabel());
        // System.out.println(getTreeItemLabel());
        Method[] methods = this.getClass().getDeclaredMethods();
        SortedMap<Integer, Method> treeGetterMethods = new TreeMap<>();
        try {
            for (Method method : methods) {
                Annotation[] annotations = method.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation instanceof TREOrder) {
                        treeGetterMethods.put(((TREOrder) annotation).order(), method);
                    }
                }
            }
            for (Method method : treeGetterMethods.values()) {
                Annotation[] annotations = method.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation instanceof TREField) {
                        TREField treField = (TREField) annotation;
                        // System.out.println(treField.label());
                        Object value = method.invoke(this);
                        if (value != null) {
                            treeItem.getChildren()
                                    .add(new TreTreeItem(treField.label(), value.toString()));
                        }
                    }
                    if (annotation instanceof TREGroup) {
                        var parts = method.invoke(this);
                        if (parts instanceof List) {
                            for (var part : (List) parts) {
                                treeItem.getChildren().add(((TreePart) part).toTreeItem());
                            }
                        }
                    }
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
        return treeItem;
    }
}
