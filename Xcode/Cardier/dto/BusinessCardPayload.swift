//
//  BusinessCardPayload.swift
//  Cardier
//
//  Created by John Choi on 1/26/24.
//

import Foundation

struct BusinessCardPayload: Identifiable {
    var id: String { displayName }
    
    var displayName: String

    var email: String

    var phone: String

    var companyName: String

    var companyLogo: String?
}
