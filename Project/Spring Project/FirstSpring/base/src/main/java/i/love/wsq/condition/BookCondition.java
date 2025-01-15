package i.love.wsq.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author baitao05
 */
public class BookCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        // 正常的配置下是应该存在有某些处理逻辑在内的
        return false;   // 返回false表示不启用
    }
}
