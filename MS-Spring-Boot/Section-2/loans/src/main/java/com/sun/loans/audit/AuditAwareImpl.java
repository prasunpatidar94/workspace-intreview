package com.sun.loans.audit;

import com.sun.loans.constant.LoansConstants;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component ("auditAwareImpl")
public class AuditAwareImpl  implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(LoansConstants.ADMIN);
    }
}
