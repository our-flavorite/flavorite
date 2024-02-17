import { Logo } from "public/svgs"

import s from './gnbServer.module.scss'
import { cn } from "utils/commonUtils"
import GnbLoginButton from "./GnbLoginButton/GnbLoginButton"

const GnbServer = () => {
    return <div className={cn(s.gnb_server)}>
        <div className={cn(s.inner)}>
        <Logo className={cn(s.logo)} />
        <div className={cn(s.login_button)}>
            <GnbLoginButton/>
        </div>
        </div>
    </div>
}

export default GnbServer
